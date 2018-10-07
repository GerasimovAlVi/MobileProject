package controller;

import pojo.Smartphone;
import service.SmartphoneService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SmartphoneServlet extends HttpServlet {
    private SmartphoneService smartphoneService;

    @Override
    public void init() throws ServletException {
        super.init();
        smartphoneService = new SmartphoneService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Smartphone> smartphoneList = smartphoneService.getAllByBrand(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("smartphone", smartphoneList);
        req.getRequestDispatcher("/smartphone.jsp").forward(req, resp);
    }
}
