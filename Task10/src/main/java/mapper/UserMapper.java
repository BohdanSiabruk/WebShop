package mapper;

import constant.Constants;
import entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import static constant.Constants.*;
import static constant.Constants.AVATAR;

public class UserMapper implements Mapper<User> {
    public UserMapper() {
    }

    public User map(ResultSet resultSet) throws SQLException {
        return  new User(resultSet.getString(FIRST_NAME), resultSet.getString(LAST_NAME),
                resultSet.getString(EMAIL), resultSet.getString(PASSWORD), resultSet.getString(AVATAR));

    }

    public static User createUser(Map<String, String> mapParam, String imagePath) {
        String firstName = mapParam.get(Constants.FIRST_NAME);
        String lastName = mapParam.get(Constants.LAST_NAME);
        String email = mapParam.get(Constants.EMAIL);
        String password = mapParam.get(Constants.PASSWORD);
        User user = new User(firstName, lastName, email, password);
        user.setAvatar(imagePath);
        return user;
    }

}
