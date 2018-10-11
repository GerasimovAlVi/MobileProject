package dao;

import pojo.Order;
import pojo.Smartphone;
import pojo.User;

import java.util.List;

public interface OrderDAO {
    public boolean add(Order order);

    public Order getById(Integer id);

    public boolean updateStatus(Order order, Integer newStatus);

    public boolean updatePaidStatus(Order order, Integer newStatus);

    public boolean deleteById(Integer id);

    public List<Order> getAll();

    public List<Order> getAllByUser(User user, Integer status);

    public List<Order> getAllByStatus(Integer status);

    public List<Smartphone> getAllSmartphone(Order order);
}
