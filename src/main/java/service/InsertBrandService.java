package service;

import dao.BrandDAO;
import daoImpl.BrandDAOImpl;
import pojo.Brand;

public class InsertBrandService {
    private BrandDAO brandDAO = new BrandDAOImpl();

    public boolean add(Brand brand) {
        return brandDAO.add(brand);
    }
}
