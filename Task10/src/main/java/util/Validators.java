package util;

import constant.Constants;
import entity.User;
import service.UserService;

import java.sql.SQLException;
import java.util.Map;

public final class Validators {
    private Validators() {
    }

    public static boolean isPresentUser(User user, String password) {
        return (user != null && user.getPassword().equals(password));
    }

    public static boolean isPresentLogin(UserService userService, Map<String, String> mapAllParameter) throws SQLException {
        return userService.findByEmail(mapAllParameter.get(Constants.EMAIL)) == null;
    }
}
