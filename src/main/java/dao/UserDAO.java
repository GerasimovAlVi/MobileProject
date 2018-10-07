package dao;

import pojo.User;

public interface UserDAO {
    public boolean add(User user);

    public User getById(Integer id);

    public boolean updateById(User user);

    public boolean deleteById(Integer id);

    public User getByLogin(String login);
}
