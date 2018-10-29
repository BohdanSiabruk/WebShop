package dao;


import entity.User;

import java.sql.SQLException;

public interface UserDao {


    boolean addUser(User user) throws SQLException;


   User findByEmail(String login) throws SQLException;

}
