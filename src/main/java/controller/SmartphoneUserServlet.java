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

public class SmartphoneUserServlet extends HttpServlet {
    private SmartphoneService smartphoneService;
    private List<Smartphone> smartphoneListAdd;

    @Override
    public void init() throws ServletException {
        super.init();
        smartphoneService = new SmartphoneService();
        smartphoneListAdd = new ArrayList<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Smartphone> smartphoneList = smartphoneService.getAllByBrand(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("smartphone", smartphoneList);
        req.getRequestDispatcher("/smartphoneUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getSession().getAttribute("shoppingCart") == null) {
            smartphoneListAdd = new ArrayList<>();
        }
        smartphoneListAdd.add(smartphoneService.getById(Integer.parseInt(req.getParameter("addInBasket"))));
        req.getSession().setAttribute("shoppingCart", smartphoneListAdd);
        resp.sendRedirect("/user/smartphone?id=" + req.getParameter("id"));
    }
}
