package service;

import dao.ReceiveTypeDAO;
import daoImpl.ReceiveTypeDAOImpl;
import pojo.ReceiveType;

public class ReceiveTypeService {
    private ReceiveTypeDAO receiveTypeDAO = new ReceiveTypeDAOImpl();

    public ReceiveType getById(Integer id) {
        return receiveTypeDAO.getById(id);
    }
}