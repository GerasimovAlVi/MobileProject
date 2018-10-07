package controller;

import service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private LoginService loginService;

    @Override
    public void init() throws ServletException {
        super.init();
        loginService = new LoginService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if ("logout".equals(req.getParameter("action"))) {
            req.getSession().invalidate();
        }
        if (loginService.checkAuth(login, password)) {
            String role = loginService.getRole(login);
            if (role.equals("administrator")) {
                resp.sendRedirect("/admin/dashBoard");
            } else {
                resp.sendRedirect("/user/dashBoard");
            }
        } else {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (loginService.checkAuth(login, password)) {
            String role = loginService.getRole(login);
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("role", role);
            if (role.equals("administrator")) {
                resp.sendRedirect("/admin/dashBoard");
            } else {
                resp.sendRedirect("/user/dashBoard");
            }
        } else {
            resp.sendRedirect("/login?errorCode=wrongLogin");
        }
    }
}
