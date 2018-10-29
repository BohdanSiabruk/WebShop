package db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionPool {


    public static DataSource initDatasource() {
        DataSource ds = null;
        try {
            Context initialContext = new InitialContext();
            Context shopContext = (Context) initialContext.lookup("java:/comp/env");
            ds = (DataSource) shopContext.lookup("jdbc/shop");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return ds;
    }
}
