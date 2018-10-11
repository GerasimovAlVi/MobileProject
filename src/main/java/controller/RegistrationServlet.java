package controller;

import pojo.User;
import service.RoleService;
import service.UserService;
import util.MD5Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {
    private RoleService roleService;
    private UserService userService;

    @Override
    public void init() throws ServletException {
        super.init();
        roleService = new RoleService();
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String insertLogin = req.getParameter("insertLogin");
        String insertPassword = req.getParameter("insertPassword");
        String insertPassword2 = req.getParameter("insertPassword2");
        String inserFirst = req.getParameter("inserFirst");
        String inserLast = req.getParameter("inserLast");
        String inserPhone = req.getParameter("inserPhone");
        String inserEmail = req.getParameter("inserEmail");
        String inserAddress = req.getParameter("inserAddress");
        if (insertPassword.equals(insertPassword2)) {
            User user = new User(null, insertLogin, MD5Util.md5Custom(insertPassword), roleService.getById(2), inserLast, inserFirst, inserPhone,
                    inserEmail, inserAddress, null);
            userService.add(user);
            req.getRequestDispatcher("/registrationOK.jsp").forward(req, resp);
        } else {
            resp.sendRedirect("/registration?errorCode=errPassword");
        }
    }
}
