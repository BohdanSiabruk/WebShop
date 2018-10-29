package service.impl;

import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import db.TransactionManager;
import entity.Order;
import service.OrderService;

import javax.sql.DataSource;
import java.sql.SQLException;

public class OrderServiceImpl implements OrderService {

    private TransactionManager transactionManager;
    private OrderDao orderDao;

    public OrderServiceImpl(DataSource dataSource) {
        this.transactionManager = new TransactionManager(dataSource);
        orderDao = new OrderDaoImpl();
    }

    @Override
    public boolean makeOrder(Order order) throws SQLException {
        System.out.println("order");
        return transactionManager.execute(() -> orderDao.makeOrder(order));
    }
}
