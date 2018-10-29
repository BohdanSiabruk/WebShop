package test.db;

import db.TransactionManager;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.assertTrue;


public class ConnectionPool{

    @Test
    public void testConnection(){
        Connection connection = TransactionManager.getConnection();
        assertTrue(connection != null);
    }
}
