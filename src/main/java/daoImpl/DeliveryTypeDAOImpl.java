package daoImpl;

import connectionManager.ConnectionManager;
import connectionManager.ConnectionManagerImpl;
import dao.DeliveryTypeDAO;
import pojo.DeliveryType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeliveryTypeDAOImpl implements DeliveryTypeDAO {
    private static ConnectionManager connectionManager = ConnectionManagerImpl.getInstance();

    @Override
    public DeliveryType getById(Integer id) {
        ResultSet resultSet = null;
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM deliverytype WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                DeliveryType deliveryType = new DeliveryType(
                        resultSet.getInt(1),
                        resultSet.getString(2));
                return deliveryType;
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
