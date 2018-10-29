package db;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionManager {
    private static DataSource ds;

    public TransactionManager(DataSource dataSource) {
        this.ds = dataSource;
    }

    public <T> T execute(Executable<T> executable) throws SQLException {
        Connection connection = null;
        T res = null;
        try {
            connection = getConnection();
            ConnectionHolder.setConnection(connection);
            res = (T) executable.executeTransaction();
            connection.commit();
        } catch (SQLException e) {
            rollBack(connection);
        } finally {
            close(connection);
        }
        return res;
    }


    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = ds.getConnection();
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }


    public static void close(Connection con) throws SQLException {
        if (con != null) {
            con.close();
        }
    }

    public static void rollBack(Connection con) throws SQLException {
        if (con != null) {
            con.rollback();
        }
    }
}
