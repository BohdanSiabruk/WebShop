package dao.impl;

import dao.UserDao;
import db.ConnectionHolder;
import entity.User;
import mapper.Mapper;
import mapper.UserMapper;
import util.UtilSQl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    private static final String SQL_ADD_USER = "INSERT INTO users (firstName, lastName, email, password, avatar) VALUES (?, ?, ?, ?, ?)";
    private static final String SQL_FIND_BY_EMAIL = "SELECT * FROM users WHERE email=?";
    private Mapper mapper = new UserMapper();

    @Override
    public boolean addUser(User user) throws SQLException {
        PreparedStatement preparedStatement;

        try {
            Connection connection = ConnectionHolder.getConnection();
            preparedStatement = connection.prepareStatement(SQL_ADD_USER);
            UtilSQl.fillStatement(preparedStatement, user.getFirstName(),
                    user.getLastName(), user.getEmail(), user.getPassword(), user.getAvatar());
            preparedStatement.execute();
        } catch (SQLException e) {
            return false;
        }
        preparedStatement.close();
        return true;
    }

    @Override
    public User findByEmail(String email) throws SQLException {
        PreparedStatement preparedStatement = null;
        User user = null;
        Connection connection = ConnectionHolder.getConnection();
        try {
            preparedStatement = connection.prepareStatement(SQL_FIND_BY_EMAIL);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = (User) mapper.map(resultSet);
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
        preparedStatement.close();
        return user;
    }
}
