package service;

import dao.SmartphoneDAO;
import daoImpl.SmartphoneDAOImpl;
import pojo.Smartphone;

import java.util.List;

public class SmartphoneService {
    private SmartphoneDAO smartphoneDAO = new SmartphoneDAOImpl();

    public List<Smartphone> getAllByBrand(Integer id) {
        return smartphoneDAO.getSmartphoneByBrandId(id);
    }

    public List<Smartphone> getAllByBrandInStock(Integer id) {
        return smartphoneDAO.getSmartphoneByBrandIdInStock(id);
    }

    public Smartphone getById(int id) {
        return smartphoneDAO.getById(id);
    }

    public boolean updateCountSubtract(Smartphone smartphone) {
        return smartphoneDAO.updateCountSubtract(smartphone);
    }

    public boolean updateCountAdd(Smartphone smartphone) {
        return smartphoneDAO.updateCountAdd(smartphone);
    }

    public double getPriceAll(List<Smartphone> smartphoneList) {
        double summPrice = 0;
        if (smartphoneList != null) {
            for (Smartphone i : smartphoneList) {
                summPrice += i.getPrice();
            }
        }
        return summPrice;
    }
}
