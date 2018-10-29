package db;

import java.sql.SQLException;

public interface Executable<T> {
        T executeTransaction() throws SQLException;
}
