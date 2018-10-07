package service;

import dao.BrandDAO;
import daoImpl.BrandDAOImpl;
import pojo.Brand;

import java.util.List;

public class BrandService {
    private BrandDAO brandDAO = new BrandDAOImpl();

    public List<Brand> getAll() {
        return brandDAO.getAll();
    }

    public Brand getByName(String name) {
        return brandDAO.getByName(name);
    }
}
