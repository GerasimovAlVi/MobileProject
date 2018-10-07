package service;

import dao.UserDAO;
import daoImpl.UserDAOImpl;
import pojo.User;

public class UserService {
    private UserDAO userDAO = new UserDAOImpl();

    public User getById(Integer id) {
        return userDAO.getById(id);
    }

    public User getByLogin(String login) {
        return userDAO.getByLogin(login);
    }
}
