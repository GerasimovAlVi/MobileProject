package daoImpl;

import connectionManager.ConnectionManager;
import connectionManager.ConnectionManagerImpl;
import dao.UserDAO;
import pojo.Role;
import pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOImpl implements UserDAO {
    private static ConnectionManager connectionManager = ConnectionManagerImpl.getInstance();

    @Override
    public boolean add(User user) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "insert into \"user\" values (default, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getRole().getId());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setString(5, user.getFirstName());
            preparedStatement.setString(6, user.getPhoneNumber());
            preparedStatement.setString(7, user.getEmail());
            preparedStatement.setString(8, user.getAddress());
            preparedStatement.setString(9, user.getCardNumber());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User getById(Integer id) {
        ResultSet resultSet = null;
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM \"user\" inner join role on \"user\".role_id = role.id WHERE \"user\".id = ?")) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        new Role(
                                resultSet.getInt(11),
                                resultSet.getString(12)
                        ),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(10));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean updateById(User user) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE \"user\" SET login = ?, password = ?, role_id = ?, lastname = ?, " +
                             "firstname = ?, phonenumber = ?, email = ?, " +
                             "address = ?, cardnumber = ? WHERE id = ?")) {
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setInt(3, user.getRole().getId());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setString(5, user.getFirstName());
            preparedStatement.setString(6, user.getPhoneNumber());
            preparedStatement.setString(7, user.getEmail());
            preparedStatement.setString(8, user.getAddress());
            preparedStatement.setString(9, user.getCardNumber());
            preparedStatement.setInt(10, user.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteById(Integer id) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM \"user\" WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User getByLogin(String login) {
        ResultSet resultSet = null;
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM \"user\" inner join role on \"user\".role_id = role.id WHERE \"user\".login = ?")) {
            preparedStatement.setString(1, login);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                User user = new User(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        new Role(
                                resultSet.getInt(11),
                                resultSet.getString(12)
                        ),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8),
                        resultSet.getString(9),
                        resultSet.getString(10));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
