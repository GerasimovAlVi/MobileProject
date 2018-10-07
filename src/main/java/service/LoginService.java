package service;

import dao.UserDAO;
import daoImpl.UserDAOImpl;
import pojo.User;
import util.MD5Util;

public class LoginService {
    private UserDAO userDAO = new UserDAOImpl();

    public User getByLogin(String login) {
        return userDAO.getByLogin(login);
    }

    public String getRole(String login) {
        User user;
        if (login != null) {
            user = userDAO.getByLogin(login);
            if (user == null) {
                return "";
            }
            return user.getRole().getRole();
        }
        return "";
    }

    public boolean checkAuth(String login, String password) {
        User user;
        if (login != null) {
            user = userDAO.getByLogin(login);
            if (user != null) {
                if (user.getPassword().equals(MD5Util.md5Custom(password))) {
                    return true;
                }
            }
        }
        return false;
    }
}
