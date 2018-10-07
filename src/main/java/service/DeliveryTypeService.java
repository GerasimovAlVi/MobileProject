package service;

import dao.DeliveryTypeDAO;
import daoImpl.DeliveryTypeDAOImpl;
import pojo.DeliveryType;

public class DeliveryTypeService {
    private DeliveryTypeDAO deliveryType = new DeliveryTypeDAOImpl();

    public DeliveryType getById(Integer id) {
        return deliveryType.getById(id);
    }
}
