package dao;

import pojo.Smartphone;

import java.util.List;

public interface SmartphoneDAO {
    public boolean add(Smartphone smartphone);

    public Smartphone getById(Integer id);

    public boolean updateById(Smartphone smartphone);

    public boolean deleteById(Integer id);

    public List<Smartphone> getSmartphoneByBrandId(Integer id);

    public List<Smartphone> getSmartphoneByBrandIdInStock(Integer id);

    public boolean updateCountSubtract(Smartphone smartphone);

    public boolean updateCountAdd(Smartphone smartphone);
}
