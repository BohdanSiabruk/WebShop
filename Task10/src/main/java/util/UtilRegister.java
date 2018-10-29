package util;

import constant.Constants;
import entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.nonNull;

public final class UtilRegister {
    private static Map<String, String> mapRegex = new HashMap<>();

    private UtilRegister() {
    }

    public static boolean checkInputValue(String value, String field) {

        return (nonNull(value) && value.length() != 0 && value.matches(mapRegex(field)));
    }

    private static String mapRegex(String value) {

        mapRegex.put(Constants.FIRST_NAME, "^[a-zA-Z ]+$");
        mapRegex.put(Constants.LAST_NAME, "^[a-zA-Z ]+$");
        mapRegex.put(Constants.EMAIL, "^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$");
        mapRegex.put(Constants.PASSWORD, "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
        mapRegex.put(Constants.CONFIRM_PASSWORD, "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
        mapRegex.put(Constants.CAPTCHA_STRING, null);

        return mapRegex.get(value);
    }

    public static void removeAttr(Map<String, String> myAttr, HttpServletRequest httpServletRequest) {
        for (Map.Entry<String, String> entry : myAttr.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            httpServletRequest.setAttribute(key, value);
        }
        myAttr.forEach((k, v) -> httpServletRequest.getSession().removeAttribute(k));
    }
    public static void setAttr(Map<String, String> myAttr,Map<String, String> mapError, HttpServletRequest httpServletRequest) {
        httpServletRequest.getSession().removeAttribute(Constants.MAP_TRUE_FIELDS);
        httpServletRequest.getSession().removeAttribute(Constants.MAP_ERRORS);

        httpServletRequest.setAttribute(Constants.MAP_TRUE_FIELDS, myAttr);
        httpServletRequest.setAttribute(Constants.MAP_ERRORS, mapError);
    }
}