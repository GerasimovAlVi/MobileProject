package daoImpl;

import connectionManager.ConnectionManager;
import connectionManager.ConnectionManagerImpl;
import dao.SmartphoneDAO;
import pojo.Brand;
import pojo.Screen;
import pojo.Smartphone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SmartphoneDAOImpl implements SmartphoneDAO {
    private static ConnectionManager connectionManager = ConnectionManagerImpl.getInstance();

    @Override
    public boolean add(Smartphone smartphone) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "insert into smartphone values (default, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {
            preparedStatement.setString(1, smartphone.getName());
            preparedStatement.setDouble(2, smartphone.getPrice());
            preparedStatement.setInt(3, smartphone.getRam());
            preparedStatement.setDouble(4, smartphone.getDiagonal());
            preparedStatement.setString(5, smartphone.getScreenResolution());
            preparedStatement.setDouble(6, smartphone.getCamera());
            preparedStatement.setInt(7, smartphone.getRom());
            preparedStatement.setInt(8, smartphone.getBatteryCapacity());
            preparedStatement.setString(9, smartphone.getSize());
            preparedStatement.setString(10, smartphone.getColor());
            preparedStatement.setInt(11, smartphone.getSimCount());
            preparedStatement.setDouble(12, smartphone.getCameraFront());
            preparedStatement.setInt(13, smartphone.getBrand().getId());
            preparedStatement.setInt(14, smartphone.getScreen().getId());
            preparedStatement.setInt(15, smartphone.getCount());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Smartphone getById(Integer id) {
        ResultSet resultSet = null;
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "select * from (smartphone inner join brand on smartphone.brand_id = brand.id) " +
                             "inner join screen on smartphone.screen_id = screen.id where smartphone.id = ?")) {
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Smartphone smartphone = new Smartphone(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getInt(4),
                        resultSet.getDouble(5),
                        resultSet.getString(6),
                        resultSet.getDouble(7),
                        resultSet.getInt(8),
                        resultSet.getInt(9),
                        resultSet.getString(10),
                        resultSet.getString(11),
                        resultSet.getInt(12),
                        resultSet.getDouble(13),
                        new Brand(
                                resultSet.getInt(17),
                                resultSet.getString(18)
                        ),
                        new Screen(
                                resultSet.getInt(19),
                                resultSet.getString(20)
                        ),
                        resultSet.getInt(16));
                return smartphone;
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
    public boolean updateById(Smartphone smartphone) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE smartphone SET name = ?, price = ?, ram = ?, diagonal = ?, screen_resolution = ?, " +
                             "camera = ?, rom = ?, battery_capacity = ?, size = ?, color = ?, " +
                             "simcount = ?, camer_front = ?, brand_id = ?, screen_id = ?, count = ? WHERE id = ?")) {
            preparedStatement.setString(1, smartphone.getName());
            preparedStatement.setDouble(2, smartphone.getPrice());
            preparedStatement.setInt(3, smartphone.getRam());
            preparedStatement.setDouble(4, smartphone.getDiagonal());
            preparedStatement.setString(5, smartphone.getScreenResolution());
            preparedStatement.setDouble(6, smartphone.getCamera());
            preparedStatement.setInt(7, smartphone.getRom());
            preparedStatement.setInt(8, smartphone.getBatteryCapacity());
            preparedStatement.setString(9, smartphone.getSize());
            preparedStatement.setString(10, smartphone.getColor());
            preparedStatement.setInt(11, smartphone.getSimCount());
            preparedStatement.setDouble(12, smartphone.getCameraFront());
            preparedStatement.setInt(13, smartphone.getBrand().getId());
            preparedStatement.setInt(14, smartphone.getScreen().getId());
            preparedStatement.setInt(15, smartphone.getCount());
            preparedStatement.setInt(16, smartphone.getId());
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
                     "DELETE FROM smartphone WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Smartphone> getSmartphoneByBrandId(Integer id) {
        List<Smartphone> list = null;
        ResultSet resultSet = null;
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "select * from (smartphone inner join brand on smartphone.brand_id = brand.id) " +
                             "inner join screen on smartphone.screen_id = screen.id where brand_id = ?")) {
            preparedStatement.setInt(1, id);
            list = new ArrayList<>();
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Smartphone smartphone = new Smartphone(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getInt(4),
                        resultSet.getDouble(5),
                        resultSet.getString(6),
                        resultSet.getDouble(7),
                        resultSet.getInt(8),
                        resultSet.getInt(9),
                        resultSet.getString(10),
                        resultSet.getString(11),
                        resultSet.getInt(12),
                        resultSet.getDouble(13),
                        new Brand(
                                resultSet.getInt(17),
                                resultSet.getString(18)
                        ),
                        new Screen(
                                resultSet.getInt(19),
                                resultSet.getString(20)
                        ),
                        resultSet.getInt(16));
                list.add(smartphone);
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
        return list;
    }

    @Override
    public List<Smartphone> getSmartphoneByBrandIdInStock(Integer id) {
        List<Smartphone> list = null;
        ResultSet resultSet = null;
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "select * from (smartphone inner join brand on smartphone.brand_id = brand.id) " +
                             "inner join screen on smartphone.screen_id = screen.id where brand_id = ? and count <> 0")) {
            preparedStatement.setInt(1, id);
            list = new ArrayList<>();
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Smartphone smartphone = new Smartphone(
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getInt(4),
                        resultSet.getDouble(5),
                        resultSet.getString(6),
                        resultSet.getDouble(7),
                        resultSet.getInt(8),
                        resultSet.getInt(9),
                        resultSet.getString(10),
                        resultSet.getString(11),
                        resultSet.getInt(12),
                        resultSet.getDouble(13),
                        new Brand(
                                resultSet.getInt(17),
                                resultSet.getString(18)
                        ),
                        new Screen(
                                resultSet.getInt(19),
                                resultSet.getString(20)
                        ),
                        resultSet.getInt(16));
                list.add(smartphone);
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
        return list;
    }

    @Override
    public boolean updateCountSubtract(Smartphone smartphone) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE smartphone SET count = ? WHERE id = ?")) {
            if (smartphone.getCount() != 0) {
                preparedStatement.setInt(1, (smartphone.getCount() - 1));
                preparedStatement.setInt(2, smartphone.getId());
                preparedStatement.execute();
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateCountAdd(Smartphone smartphone) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE smartphone SET count = ? WHERE id = ?")) {
            preparedStatement.setInt(1, (smartphone.getCount() + 1));
            preparedStatement.setInt(2, smartphone.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
