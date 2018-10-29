package service;


import entity.User;

import java.sql.SQLException;

public interface UserService {

    void addUser(User user) throws SQLException;

    User findByEmail(String login) throws SQLException;
}
