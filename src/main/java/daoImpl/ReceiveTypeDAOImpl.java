package daoImpl;

import connectionManager.ConnectionManager;
import connectionManager.ConnectionManagerImpl;
import dao.ReceiveTypeDAO;
import pojo.ReceiveType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReceiveTypeDAOImpl implements ReceiveTypeDAO {
    private static ConnectionManager connectionManager = ConnectionManagerImpl.getInstance();

    @Override
    public ReceiveType getById(Integer id) {
        ResultSet resultSet = null;
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM receivetype WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                ReceiveType receiveType = new ReceiveType(
                        resultSet.getInt(1),
                        resultSet.getString(2));
                return receiveType;
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
