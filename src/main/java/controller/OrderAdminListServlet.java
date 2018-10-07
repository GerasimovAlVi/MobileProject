package controller;

import pojo.Order;
import pojo.Smartphone;
import pojo.User;
import service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class OrderAdminListServlet extends HttpServlet {
    private OrderService orderService;

    @Override
    public void init() throws ServletException {
        super.init();
        orderService = new OrderService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orderList = orderService.getAllByStatus(2);
        for (Order i : orderList) {
            User user = i.getUser();
            req.setAttribute("user", user);
            List<Smartphone> smartphoneList = i.getSmartphone();
            req.setAttribute("smartphone" + i.getId(), smartphoneList);
        }
        req.setAttribute("order", orderList);
        req.getRequestDispatcher("/orderListAdmin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
