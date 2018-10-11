package service;

import dao.RoleDAO;
import daoImpl.RoleDAOImpl;
import pojo.Role;

public class RoleService {
    private RoleDAO roleDAO = new RoleDAOImpl();

    public Role getById(Integer id) {
        return roleDAO.getById(id);
    }
}
