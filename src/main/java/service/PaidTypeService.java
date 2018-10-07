package service;

import dao.PaidTypeDAO;
import daoImpl.PaidTypeDAOImpl;
import pojo.PaidType;

public class PaidTypeService {
    private PaidTypeDAO paidTypeDAO = new PaidTypeDAOImpl();

    public PaidType getById(Integer id) {
        return paidTypeDAO.getById(id);
    }
}
