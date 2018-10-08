package controller;

import pojo.Order;
import pojo.Smartphone;
import service.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderUserServlet extends HttpServlet {
    private SmartphoneService smartphoneService;
    private List<Smartphone> shoppingCart;
    private OrderService orderService;
    private UserService userService;
    private DeliveryTypeService deliveryTypeService;
    private PaidTypeService paidTypeService;
    private ReceiveTypeService receiveTypeService;


    @Override
    public void init() throws ServletException {
        super.init();
        smartphoneService = new SmartphoneService();
        shoppingCart = new ArrayList<>();
        orderService = new OrderService();
        userService = new UserService();
        deliveryTypeService = new DeliveryTypeService();
        paidTypeService = new PaidTypeService();
        receiveTypeService = new ReceiveTypeService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        shoppingCart = (List<Smartphone>) req.getSession().getAttribute("shoppingCart");
        double sumPrice = smartphoneService.getPriceAll(shoppingCart);
        req.setAttribute("sumPrice", sumPrice);
        req.getRequestDispatcher("/order.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int delivery;
        int paid;
        if (req.getParameter("delivery").equals("Yes")) {
            delivery = 1;
        } else {
            delivery = 2;
        }
        if (req.getParameter("paid").equals("Yes")) {
            paid = 1;
        } else {
            paid = 2;
        }
        Order order = new Order(null,
                userService.getByLogin((String) req.getSession().getAttribute("login")),
                (List<Smartphone>) req.getSession().getAttribute("shoppingCart"),
                deliveryTypeService.getById(delivery),
                paidTypeService.getById(paid),
                receiveTypeService.getById(2));
        if (order != null) {
            List<Smartphone> smartphoneList = order.getSmartphone();
            boolean good = true;
            for (Smartphone i : smartphoneList) {
                if (i.getCount() == 0) {
                    good = false;
                    break;
                }
            }
            if (good) {
                orderService.add(order);
                for (Smartphone i : smartphoneList) {
                    smartphoneService.updateCountSubtract(i);
                }
            }
        }
        req.getRequestDispatcher("/orderStatus.jsp").forward(req, resp);
    }
}
