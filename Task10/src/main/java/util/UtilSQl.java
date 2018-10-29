package util;

import context.ProductContext;
import db.ConnectionHolder;
import entity.Order;
import entity.Product;
import enumeration.Status;
import mapper.ProductMapper;

import java.sql.*;
import java.util.Map;

public final class UtilSQl {

    private static ProductMapper mapper = new ProductMapper();

    private UtilSQl() {
    }

    public static void fillStatement(PreparedStatement pstmt, Object... objs) throws SQLException {
        int count = 1;
        for (Object param : objs) {
            pstmt.setObject(count++, param);

        }
    }


    public static Product getProductFromBase(int id) throws SQLException {
        Product product = null;
        String sql = "select * from products where id=?";
        PreparedStatement statement;

        Connection connection = ConnectionHolder.getConnection();
        statement = connection.prepareStatement(sql);
        fillStatement(statement, id);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            product = mapper.map(rs);
        }
        return product;
    }

    public static int writeStatus(String sql) throws SQLException {
        Statement statement;
        Connection connection = ConnectionHolder.getConnection();
        statement = connection.createStatement();
        return statement.executeUpdate(sql);
    }

}