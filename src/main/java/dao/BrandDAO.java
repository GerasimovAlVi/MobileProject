package dao;

import pojo.Brand;

import java.util.List;

public interface BrandDAO {
    public boolean add(Brand brand);

    public Brand getById(Integer id);

    public boolean updateById(Brand brand);

    public boolean deleteById(Integer id);

    public List<Brand> getAll();

    public Brand getByName(String name);
}
