package service;

import dao.SmartphoneDAO;
import daoImpl.SmartphoneDAOImpl;
import pojo.Smartphone;

public class InsertSmartphoneService {
    SmartphoneDAO smartphoneDAO = new SmartphoneDAOImpl();

    public boolean add(Smartphone smartphone) {
        return smartphoneDAO.add(smartphone);
    }
}
