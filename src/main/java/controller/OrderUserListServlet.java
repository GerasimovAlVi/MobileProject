package controller;

import pojo.Order;
import pojo.Smartphone;
import service.OrderService;
import service.SmartphoneService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderUserListServlet extends HttpServlet {
    private OrderService orderService;
    private UserService userService;
    private SmartphoneService smartphoneService;

    @Override
    public void init() throws ServletException {
        super.init();
        orderService = new OrderService();
        userService = new UserService();
        smartphoneService = new SmartphoneService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orderList = orderService.getAllByUser(userService
                .getByLogin(((String) req.getSession().getAttribute("login"))), 2);
        for (Order i : orderList) {
            List<Smartphone> smartphoneList = i.getSmartphone();
            req.setAttribute("smartphone" + i.getId(), smartphoneList);
        }
        req.setAttribute("order", orderList);
        req.getRequestDispatcher("/orderListUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order = orderService.getById(Integer.parseInt(req.getParameter("cancel")));
        List<Smartphone> smartphoneList = order.getSmartphone();
        for (Smartphone i : smartphoneList) {
            smartphoneService.updateCountAdd(i);
        }
        orderService.updateStatus(order, 3);
        resp.sendRedirect("/user/orderList");
    }
}
