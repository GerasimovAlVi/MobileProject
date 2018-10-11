package daoImpl;

import connectionManager.ConnectionManager;
import connectionManager.ConnectionManagerImpl;
import dao.BrandDAO;
import pojo.Brand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandDAOImpl implements BrandDAO {
    private static ConnectionManager connectionManager = ConnectionManagerImpl.getInstance();

    @Override
    public boolean add(Brand brand) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "insert into brand values (default, ?)")) {
            preparedStatement.setString(1, brand.getName());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Brand getById(Integer id) {
        ResultSet resultSet = null;
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM brand WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Brand brand = new Brand(
                        resultSet.getInt(1),
                        resultSet.getString(2));
                return brand;
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

    @Override
    public boolean updateById(Brand brand) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE brand SET name = ? WHERE id = ?")) {
            preparedStatement.setString(1, brand.getName());
            preparedStatement.setInt(2, brand.getId());
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
                     "DELETE FROM brand WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Brand> getAll() {
        List<Brand> list = null;
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM brand");
             ResultSet resultSet = preparedStatement.executeQuery()) {
            list = new ArrayList<>();
            while (resultSet.next()) {
                Brand brand = new Brand(
                        resultSet.getInt(1),
                        resultSet.getString(2));
                list.add(brand);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Brand getByName(String name) {
        ResultSet resultSet = null;
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM brand WHERE name = ?")) {
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Brand brand = new Brand(
                        resultSet.getInt(1),
                        resultSet.getString(2));
                return brand;
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
