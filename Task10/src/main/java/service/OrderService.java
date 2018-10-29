package service;

import entity.Order;

import java.sql.SQLException;

public interface OrderService {
    boolean makeOrder(Order order) throws SQLException;
}
