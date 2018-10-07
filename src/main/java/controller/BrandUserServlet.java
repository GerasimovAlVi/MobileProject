package controller;

import service.BrandService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BrandUserServlet extends HttpServlet {
    private BrandService brandService;

    @Override
    public void init() throws ServletException {
        super.init();
        brandService = new BrandService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("brand", brandService.getAll());
        req.getRequestDispatcher("/brandUser.jsp").forward(req, resp);
    }
}
