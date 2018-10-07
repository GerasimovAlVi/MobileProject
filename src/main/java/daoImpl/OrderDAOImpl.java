package daoImpl;

import connectionManager.ConnectionManager;
import connectionManager.ConnectionManagerImpl;
import dao.OrderDAO;
import pojo.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    private static ConnectionManager connectionManager = ConnectionManagerImpl.getInstance();

    @Override
    public boolean add(Order order) {
        List<Smartphone> smartphoneList = order.getSmartphone();
        List<Integer> smartphoneListId = new ArrayList<>();
        for (Smartphone i : smartphoneList) {
            smartphoneListId.add(i.getId());
        }
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "insert into \"order2\" values (default, ?, ?, ?, ?, ?)")) {
            preparedStatement.setInt(1, order.getUser().getId());
            Array array = connection.createArrayOf("INTEGER", smartphoneListId.toArray());
            preparedStatement.setArray(2, array);
            preparedStatement.setInt(3, order.getDeliveryType().getId());
            preparedStatement.setInt(4, order.getPaidType().getId());
            preparedStatement.setInt(5, order.getReceiveType().getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Order getById(Integer id) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "select * from ((((\"order2\" inner join \"user\" on \"order2\".user_id = \"user\".id)\n" +
                             "  inner join role on \"user\".role_id = role.id)\n" +
                             "  inner join deliverytype on \"order2\".delivery = deliverytype.id)\n" +
                             "  inner join paidtype on \"order2\".paid = paidtype.id)\n" +
                             "  inner join receivetype on \"order2\".receive = receivetype.id where \"order2\".id = ?")) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                List<Smartphone> smartphoneList = new ArrayList<>();
                List<Integer> list = Arrays.asList((Integer[]) resultSet.getArray(3).getArray());
                PreparedStatement preparedStatement2 = connection.prepareStatement(
                        "select * from (smartphone inner join brand on smartphone.brand_id = brand.id)" +
                                "inner join screen on smartphone.screen_id = screen.id where smartphone.id = ?");
                for (Integer i : list) {
                    preparedStatement2.setInt(1, i);
                    ResultSet resultSet2 = preparedStatement2.executeQuery();
                    while (resultSet2.next()) {
                        Smartphone smartphone = new Smartphone(
                                resultSet2.getInt(1),
                                resultSet2.getString(2),
                                resultSet2.getDouble(3),
                                resultSet2.getInt(4),
                                resultSet2.getDouble(5),
                                resultSet2.getString(6),
                                resultSet2.getDouble(7),
                                resultSet2.getInt(8),
                                resultSet2.getInt(9),
                                resultSet2.getString(10),
                                resultSet2.getString(11),
                                resultSet2.getInt(12),
                                resultSet2.getDouble(13),
                                new Brand(
                                        resultSet2.getInt(16),
                                        resultSet2.getString(17)
                                ),
                                new Screen(
                                        resultSet2.getInt(18),
                                        resultSet2.getString(19)
                                ));
                        smartphoneList.add(smartphone);
                    }
                }

                Order order = new Order(
                        resultSet.getInt(1),
                        new User(
                                resultSet.getInt(7),
                                resultSet.getString(8),
                                resultSet.getString(9),
                                new Role(
                                        resultSet.getInt(17),
                                        resultSet.getString(18)
                                ),
                                resultSet.getString(11),
                                resultSet.getString(12),
                                resultSet.getString(13),
                                resultSet.getString(14),
                                resultSet.getString(15),
                                resultSet.getString(16)
                        ),
                        smartphoneList,
                        new DeliveryType(
                                resultSet.getInt(19),
                                resultSet.getString(20)
                        ),
                        new PaidType(
                                resultSet.getInt(21),
                                resultSet.getString(22)
                        ),
                        new ReceiveType(
                                resultSet.getInt(23),
                                resultSet.getString(24)
                        ));
                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /*@Override
    public Order getById(Integer id) {
        try(Connection connection = connectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "select * from (((((((\"order\" inner join \"user\" on \"order\".user_id = \"user\".id)\n" +
                            "  inner join role on \"user\".role_id = role.id)\n" +
                            "  inner join deliverytype on \"order\".delivery = deliverytype.id)\n" +
                            "  inner join paidtype on \"order\".paid = paidtype.id)\n" +
                            "  inner join receivetype on \"order\".receive = receivetype.id)\n" +
                            "  inner join smartphone on \"order\".smartphone_id = smartphone.id)\n" +
                            "  inner join screen on smartphone.screen_id = screen.id)\n" +
                            "  inner join brand on smartphone.brand_id = brand.id where \"order\".id = ?")){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                Order order = new Order(
                        resultSet.getInt(1),
                        new User(
                                resultSet.getInt(7),
                                resultSet.getString(8),
                                resultSet.getString(9),
                                new Role(
                                        resultSet.getInt(17),
                                        resultSet.getString(18)
                                ),
                                resultSet.getString(11),
                                resultSet.getString(12),
                                resultSet.getString(13),
                                resultSet.getString(14),
                                resultSet.getString(15),
                                resultSet.getString(16)
                        ),
                        new Smartphone(
                                resultSet.getInt(25),
                                resultSet.getString(26),
                                resultSet.getDouble(27),
                                resultSet.getInt(28),
                                resultSet.getDouble(29),
                                resultSet.getString(30),
                                resultSet.getDouble(31),
                                resultSet.getInt(32),
                                resultSet.getInt(33),
                                resultSet.getString(34),
                                resultSet.getString(35),
                                resultSet.getInt(36),
                                resultSet.getDouble(37),
                                new Brand(
                                        resultSet.getInt(42),
                                        resultSet.getString(43)
                                ),
                                new Screen(
                                        resultSet.getInt(40),
                                        resultSet.getString(41)
                                )
                        ),
                        new DeliveryType(
                                resultSet.getInt(19),
                                resultSet.getString(20)
                        ),
                        new PaidType(
                                resultSet.getInt(21),
                                resultSet.getString(22)
                        ),
                        new ReceiveType(
                                resultSet.getInt(23),
                                resultSet.getString(24)
                        ));
                return order;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }*/

    @Override
    public boolean updateStatus(Order order, Integer newStatus) {
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE \"order2\" SET receive = ? WHERE id = ?")) {
            preparedStatement.setInt(1, newStatus);
            preparedStatement.setInt(2, order.getId());
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
                     "DELETE FROM \"order2\" WHERE id = ?")) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Order> getAll() {
        List<Order> listOrder = new ArrayList<>();
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "select * from ((((\"order2\" inner join \"user\" on \"order2\".user_id = \"user\".id)\n" +
                             "  inner join role on \"user\".role_id = role.id)\n" +
                             "  inner join deliverytype on \"order2\".delivery = deliverytype.id)\n" +
                             "  inner join paidtype on \"order2\".paid = paidtype.id)\n" +
                             "  inner join receivetype on \"order2\".receive = receivetype.id")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                List<Smartphone> smartphoneList = new ArrayList<>();
                ;
                List<Integer> list = Arrays.asList((Integer[]) resultSet.getArray(3).getArray());
                PreparedStatement preparedStatement2 = connection.prepareStatement(
                        "select * from (smartphone inner join brand on smartphone.brand_id = brand.id)" +
                                "inner join screen on smartphone.screen_id = screen.id where smartphone.id = ?");
                for (Integer i : list) {
                    preparedStatement2.setInt(1, i);
                    ResultSet resultSet2 = preparedStatement2.executeQuery();
                    while (resultSet2.next()) {
                        Smartphone smartphone = new Smartphone(
                                resultSet2.getInt(1),
                                resultSet2.getString(2),
                                resultSet2.getDouble(3),
                                resultSet2.getInt(4),
                                resultSet2.getDouble(5),
                                resultSet2.getString(6),
                                resultSet2.getDouble(7),
                                resultSet2.getInt(8),
                                resultSet2.getInt(9),
                                resultSet2.getString(10),
                                resultSet2.getString(11),
                                resultSet2.getInt(12),
                                resultSet2.getDouble(13),
                                new Brand(
                                        resultSet2.getInt(16),
                                        resultSet2.getString(17)
                                ),
                                new Screen(
                                        resultSet2.getInt(18),
                                        resultSet2.getString(19)
                                ));
                        smartphoneList.add(smartphone);
                    }
                }
                Order order = new Order(
                        resultSet.getInt(1),
                        new User(
                                resultSet.getInt(7),
                                resultSet.getString(8),
                                resultSet.getString(9),
                                new Role(
                                        resultSet.getInt(17),
                                        resultSet.getString(18)
                                ),
                                resultSet.getString(11),
                                resultSet.getString(12),
                                resultSet.getString(13),
                                resultSet.getString(14),
                                resultSet.getString(15),
                                resultSet.getString(16)
                        ),
                        smartphoneList,
                        new DeliveryType(
                                resultSet.getInt(19),
                                resultSet.getString(20)
                        ),
                        new PaidType(
                                resultSet.getInt(21),
                                resultSet.getString(22)
                        ),
                        new ReceiveType(
                                resultSet.getInt(23),
                                resultSet.getString(24)
                        ));
                listOrder.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOrder;
    }

    @Override
    public List<Order> getAllByUser(User user, Integer status) {
        List<Order> listOrder = new ArrayList<>();
        ;
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "select * from ((((\"order2\" inner join \"user\" on \"order2\".user_id = \"user\".id)\n" +
                             "  inner join role on \"user\".role_id = role.id)\n" +
                             "  inner join deliverytype on \"order2\".delivery = deliverytype.id)\n" +
                             "  inner join paidtype on \"order2\".paid = paidtype.id)\n" +
                             "  inner join receivetype on \"order2\".receive = receivetype.id where user_id = ? and receivetype.id = ?")) {
            preparedStatement.setInt(1, user.getId());
            preparedStatement.setInt(2, status);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                List<Smartphone> smartphoneList = new ArrayList<>();
                List<Integer> list = Arrays.asList((Integer[]) resultSet.getArray(3).getArray());
                PreparedStatement preparedStatement2 = connection.prepareStatement(
                        "select * from (smartphone inner join brand on smartphone.brand_id = brand.id)" +
                                "inner join screen on smartphone.screen_id = screen.id where smartphone.id = ?");
                for (Integer i : list) {
                    preparedStatement2.setInt(1, i);
                    ResultSet resultSet2 = preparedStatement2.executeQuery();
                    while (resultSet2.next()) {
                        Smartphone smartphone = new Smartphone(
                                resultSet2.getInt(1),
                                resultSet2.getString(2),
                                resultSet2.getDouble(3),
                                resultSet2.getInt(4),
                                resultSet2.getDouble(5),
                                resultSet2.getString(6),
                                resultSet2.getDouble(7),
                                resultSet2.getInt(8),
                                resultSet2.getInt(9),
                                resultSet2.getString(10),
                                resultSet2.getString(11),
                                resultSet2.getInt(12),
                                resultSet2.getDouble(13),
                                new Brand(
                                        resultSet2.getInt(16),
                                        resultSet2.getString(17)
                                ),
                                new Screen(
                                        resultSet2.getInt(18),
                                        resultSet2.getString(19)
                                ));
                        smartphoneList.add(smartphone);
                    }
                }
                Order order = new Order(
                        resultSet.getInt(1),
                        new User(
                                resultSet.getInt(7),
                                resultSet.getString(8),
                                resultSet.getString(9),
                                new Role(
                                        resultSet.getInt(17),
                                        resultSet.getString(18)
                                ),
                                resultSet.getString(11),
                                resultSet.getString(12),
                                resultSet.getString(13),
                                resultSet.getString(14),
                                resultSet.getString(15),
                                resultSet.getString(16)
                        ),
                        smartphoneList,
                        new DeliveryType(
                                resultSet.getInt(19),
                                resultSet.getString(20)
                        ),
                        new PaidType(
                                resultSet.getInt(21),
                                resultSet.getString(22)
                        ),
                        new ReceiveType(
                                resultSet.getInt(23),
                                resultSet.getString(24)
                        ));
                listOrder.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOrder;
    }

    @Override
    public List<Order> getAllByStatus(Integer status) {
        List<Order> listOrder = new ArrayList<>();
        ;
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "select * from ((((\"order2\" inner join \"user\" on \"order2\".user_id = \"user\".id)\n" +
                             "  inner join role on \"user\".role_id = role.id)\n" +
                             "  inner join deliverytype on \"order2\".delivery = deliverytype.id)\n" +
                             "  inner join paidtype on \"order2\".paid = paidtype.id)\n" +
                             "  inner join receivetype on \"order2\".receive = receivetype.id where receivetype.id = ?")) {
            preparedStatement.setInt(1, status);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                List<Smartphone> smartphoneList = new ArrayList<>();
                List<Integer> list = Arrays.asList((Integer[]) resultSet.getArray(3).getArray());
                PreparedStatement preparedStatement2 = connection.prepareStatement(
                        "select * from (smartphone inner join brand on smartphone.brand_id = brand.id)" +
                                "inner join screen on smartphone.screen_id = screen.id where smartphone.id = ?");
                for (Integer i : list) {
                    preparedStatement2.setInt(1, i);
                    ResultSet resultSet2 = preparedStatement2.executeQuery();
                    while (resultSet2.next()) {
                        Smartphone smartphone = new Smartphone(
                                resultSet2.getInt(1),
                                resultSet2.getString(2),
                                resultSet2.getDouble(3),
                                resultSet2.getInt(4),
                                resultSet2.getDouble(5),
                                resultSet2.getString(6),
                                resultSet2.getDouble(7),
                                resultSet2.getInt(8),
                                resultSet2.getInt(9),
                                resultSet2.getString(10),
                                resultSet2.getString(11),
                                resultSet2.getInt(12),
                                resultSet2.getDouble(13),
                                new Brand(
                                        resultSet2.getInt(16),
                                        resultSet2.getString(17)
                                ),
                                new Screen(
                                        resultSet2.getInt(18),
                                        resultSet2.getString(19)
                                ));
                        smartphoneList.add(smartphone);
                    }
                }
                Order order = new Order(
                        resultSet.getInt(1),
                        new User(
                                resultSet.getInt(7),
                                resultSet.getString(8),
                                resultSet.getString(9),
                                new Role(
                                        resultSet.getInt(17),
                                        resultSet.getString(18)
                                ),
                                resultSet.getString(11),
                                resultSet.getString(12),
                                resultSet.getString(13),
                                resultSet.getString(14),
                                resultSet.getString(15),
                                resultSet.getString(16)
                        ),
                        smartphoneList,
                        new DeliveryType(
                                resultSet.getInt(19),
                                resultSet.getString(20)
                        ),
                        new PaidType(
                                resultSet.getInt(21),
                                resultSet.getString(22)
                        ),
                        new ReceiveType(
                                resultSet.getInt(23),
                                resultSet.getString(24)
                        ));
                listOrder.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listOrder;
    }

    @Override
    public List<Smartphone> getAllSmartphone(Order order) {
        List<Smartphone> smartphoneList = new ArrayList<>();
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "select * from \"order2\" where id = ?")) {
            preparedStatement.setInt(1, order.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                List<Integer> list = Arrays.asList((Integer[]) resultSet.getArray(3).getArray());
                PreparedStatement preparedStatement2 = connection.prepareStatement(
                        "select * from (smartphone inner join brand on smartphone.brand_id = brand.id)" +
                                "inner join screen on smartphone.screen_id = screen.id where smartphone.id = ?");
                for (Integer i : list) {
                    preparedStatement2.setInt(1, i);
                    ResultSet resultSet2 = preparedStatement2.executeQuery();
                    while (resultSet2.next()) {
                        Smartphone smartphone = new Smartphone(
                                resultSet2.getInt(1),
                                resultSet2.getString(2),
                                resultSet2.getDouble(3),
                                resultSet2.getInt(4),
                                resultSet2.getDouble(5),
                                resultSet2.getString(6),
                                resultSet2.getDouble(7),
                                resultSet2.getInt(8),
                                resultSet2.getInt(9),
                                resultSet2.getString(10),
                                resultSet2.getString(11),
                                resultSet2.getInt(12),
                                resultSet2.getDouble(13),
                                new Brand(
                                        resultSet2.getInt(16),
                                        resultSet2.getString(17)
                                ),
                                new Screen(
                                        resultSet2.getInt(18),
                                        resultSet2.getString(19)
                                ));
                        smartphoneList.add(smartphone);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return smartphoneList;
    }
}
