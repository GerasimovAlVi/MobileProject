package service;

import dao.OrderDAO;
import daoImpl.OrderDAOImpl;
import pojo.Order;
import pojo.Smartphone;
import pojo.User;

import java.util.List;

public class OrderService {
    private OrderDAO orderDAO = new OrderDAOImpl();

    public List<Order> getAll() {
        return orderDAO.getAll();
    }

    public List<Order> getAllByUser(User user, Integer status) {
        return orderDAO.getAllByUser(user, status);
    }

    public List<Order> getAllByStatus(Integer status) {
        return orderDAO.getAllByStatus(status);
    }

    public void add(Order order) {
        orderDAO.add(order);
    }

    public List<Smartphone> getAllSmartphone(Order order) {
        return orderDAO.getAllSmartphone(order);
    }

    public void updateStatus(Order order, Integer newStatus) {
        orderDAO.updateStatus(order, newStatus);
    }

    public Order getById(Integer id) {
        return orderDAO.getById(id);
    }
}
