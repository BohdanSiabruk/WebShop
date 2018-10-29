package dao;

import entity.Order;

import java.sql.SQLException;

public interface OrderDao {
    boolean makeOrder(Order order) throws SQLException;
}
