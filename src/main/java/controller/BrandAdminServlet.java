package controller;

import pojo.Brand;
import service.BrandService;
import service.InsertBrandService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BrandAdminServlet extends HttpServlet {
    private BrandService brandService;
    private InsertBrandService insertBrandService;

    @Override
    public void init() throws ServletException {
        super.init();
        brandService = new BrandService();
        insertBrandService = new InsertBrandService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("brand", brandService.getAll());
        req.getRequestDispatcher("/brandAdmin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String brandName = req.getParameter("insertBrand");
        Brand brand = new Brand(null, brandName);
        if (!brandName.equals("")) {
            insertBrandService.add(brand);
        }
        this.doGet(req, resp);
    }
}
