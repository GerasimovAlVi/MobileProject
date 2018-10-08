package controller;

import dao.BrandDAO;
import dao.ScreenDAO;
import daoImpl.BrandDAOImpl;
import daoImpl.ScreenDAOImpl;
import pojo.Smartphone;
import service.BrandService;
import service.InsertSmartphoneService;
import service.ScreenService;
import service.SmartphoneService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SmartphoneAdminServlet extends HttpServlet {
    private SmartphoneService smartphoneService;
    private InsertSmartphoneService insertSmartphoneService;
    private BrandDAO brandDAO;
    private ScreenDAO screenDAO;
    private BrandService brandService;
    private ScreenService screenService;

    @Override
    public void init() throws ServletException {
        super.init();
        smartphoneService = new SmartphoneService();
        insertSmartphoneService = new InsertSmartphoneService();
        brandDAO = new BrandDAOImpl();
        screenDAO = new ScreenDAOImpl();
        brandService = new BrandService();
        screenService = new ScreenService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Smartphone> smartphoneList = smartphoneService.getAllByBrand(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("smartphone", smartphoneList);
        req.setAttribute("brand", brandService.getAll());
        req.setAttribute("screen", screenService.getAll());
        req.getRequestDispatcher("/smartphoneAdmin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inserBrand = req.getParameter("inserBrand");
        String insertName = req.getParameter("insertName");
        double inserPrace = Double.parseDouble(req.getParameter("inserPrace"));
        int inserRam = Integer.parseInt(req.getParameter("inserRam"));
        int inserRom = Integer.parseInt(req.getParameter("inserRom"));
        double inserDiagonal = Double.parseDouble(req.getParameter("inserDiagonal"));
        String inserScreenResolution = req.getParameter("inserScreenResolution");
        String inserScreen = req.getParameter("inserScreen");
        double inserCamera = Double.parseDouble(req.getParameter("inserCamera"));
        double inserCameraFront = Double.parseDouble(req.getParameter("inserCameraFront"));
        int inserBatteryCapacity = Integer.parseInt(req.getParameter("inserBatteryCapacity"));
        int inserSimCount = Integer.parseInt(req.getParameter("inserSimCount"));
        String inserSize = req.getParameter("inserSize");
        String inserColor = req.getParameter("inserColor");
        int inserCount = Integer.parseInt(req.getParameter("inserCount"));
        Smartphone smartphone = new Smartphone(null, insertName, inserPrace, inserRam, inserDiagonal,
                inserScreenResolution, inserCamera, inserRom, inserBatteryCapacity,
                inserSize, inserColor, inserSimCount, inserCameraFront,
                brandDAO.getByName(inserBrand),
                screenDAO.getByName(inserScreen),
                inserCount);
        if (!smartphone.equals("")) {
            insertSmartphoneService.add(smartphone);
        }
        resp.sendRedirect("/admin/smartphone?id=" + smartphone.getBrand().getId());
    }
}
