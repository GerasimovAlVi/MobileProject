package controller;

import pojo.Smartphone;
import service.SmartphoneService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartServlet extends HttpServlet {
    private SmartphoneService smartphoneService;
    private List<Smartphone> shoppingCart;

    @Override
    public void init() throws ServletException {
        super.init();
        smartphoneService = new SmartphoneService();
        shoppingCart = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        shoppingCart = (List<Smartphone>) req.getSession().getAttribute("shoppingCart");
        req.setAttribute("shoppingCartViev", shoppingCart);
        req.getRequestDispatcher("/shoppingCart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        shoppingCart.remove(smartphoneService.getById(Integer.parseInt(req.getParameter("deleteInBasket"))));
        req.getSession().setAttribute("shoppingCart", shoppingCart);
        resp.sendRedirect("/user/shoppingCart");
    }
}
