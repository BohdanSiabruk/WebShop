package dao.impl;

import context.ProductContext;
import dao.OrderDao;
import db.ConnectionHolder;
import entity.Order;
import util.UtilSQl;

import java.sql.*;
import java.util.Map;
import java.util.Objects;

public class OrderDaoImpl implements OrderDao {
    private static final String SQL_ADD_ORDER = "INSERT INTO orders (id, status, status_info, date, login_user) VALUES (default, ?, ?, ?, ?)";
    private static final String SQL_ADD_ORDER_LIST = "INSERT INTO basket_products (id, idProd, firm, model, price, amountl) VALUES (default,?, ?, ?, ?, ?)";
    private static final String SQL_ID_ORDER = "SELECT MAX(id) FROM orders; ";

    @Override
    public boolean makeOrder(Order order) throws SQLException {
        PreparedStatement preparedStatement = null;


        Connection connection = ConnectionHolder.getConnection();
        preparedStatement = connection.prepareStatement(SQL_ADD_ORDER);
        UtilSQl.fillStatement(preparedStatement, order.getStatus().status, order.getInfo(), order.getDate().toString(), order.getLogin());
        preparedStatement.execute();
        int id = returnId();
        makeOderList(order, id);

        return true;
    }

    private boolean makeOderList(Order order, int id) throws SQLException {
        PreparedStatement preparedStatement = null;

        try {
            Connection connection = ConnectionHolder.getConnection();
            preparedStatement = connection.prepareStatement(SQL_ADD_ORDER_LIST);

            for (Map.Entry<Integer, ProductContext> entry : order.getMapBasket().entrySet()) {
                UtilSQl.fillStatement(preparedStatement, id, entry.getValue().getProduct().getFirm(), entry.getValue().getProduct().getModel(),
                        entry.getValue().getProduct().getPrice(), entry.getValue().getCount());

                preparedStatement.execute();
            }
        } finally {
            Objects.requireNonNull(preparedStatement).close();
        }
        return true;
    }

    private int returnId() throws SQLException {
        Statement statement;

        Connection connection = ConnectionHolder.getConnection();
        statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_ID_ORDER);
        resultSet.next();

        return resultSet.getInt("MAX(id)");
    }
}
