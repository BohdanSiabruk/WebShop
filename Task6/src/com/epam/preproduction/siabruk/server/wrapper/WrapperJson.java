package com.epam.preproduction.siabruk.server.wrapper;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class WrapperJson {


    private WrapperJson() {
    }

    public static String wrappString(String conclusion) {

        StringBuilder jsonString = new StringBuilder();
        jsonString.append("{\r\n");
        jsonString.append(conclusion);
        jsonString.append("\r\n");
        jsonString.append("}\r\n");

        String response = "HTTP/1.1 200 OK\r\n" +
                "Server:http\r\n" +
                "Content-Type:json\r\n" +
                "Content-Length:" +
                jsonString.length() +
                "\r\n" +
                "Date:" +
                new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()) +
                "\r\n" +
                "Connection:close\r\n\r\n" +
                jsonString;
        return response;

    }

}
