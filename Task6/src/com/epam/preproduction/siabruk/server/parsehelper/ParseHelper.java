package com.epam.preproduction.siabruk.server.parsehelper;

import com.epam.preproduction.siabruk.server.Request;

public final class ParseHelper {
    private ParseHelper() {
    }
    public static Request parseRequest(String data) {
        Request request = new Request();

        String url = backUrl(data);

        if (!data.contains("?")) {
            if (data.matches("[\\S]+(=)[\\S]+")){
                String[] nameValue = data.split("=");
                request.setAttribute(nameValue[0], nameValue[1]);
            } else {
                request.setMethodCommand(url);
            }
        } else {
            System.out.println(url.substring(0, url.indexOf("?")));
            request.setMethodCommand(url.substring(0, url.indexOf("?")));
            String lineWithParameter = url.substring(url.indexOf("?")+1).trim();
            for (String paramValue : lineWithParameter.split("&")) {
                if (paramValue.matches("[\\S]+(=)[\\S]+")) {
                    String[] pare = paramValue.split("=");
                    request.setAttribute(pare[0], pare[1]);
                }
            }
        }
        return request;
    }

    private static String backUrl(String data){
       String firstLine;
        if (data.startsWith("GET")) {
            firstLine = data.substring(0, data.indexOf("\n")).trim();
            String[] parseFirstLine = firstLine.split(" ");
            return parseFirstLine[1];
        } else {
            return data;
        }
    }
}