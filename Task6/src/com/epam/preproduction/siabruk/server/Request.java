package com.epam.preproduction.siabruk.server;

import java.util.HashMap;
import java.util.Map;

public class Request {

    private Map<String, Object> mapRequest = new HashMap<>();
    private String methodCommand;

    public Object getAttribute(String key) {
        return mapRequest.get(key);
    }

    public void setAttribute(String key, Object value) {
        mapRequest.put(key, value);
    }

    public String getMethodCommand() {
        return methodCommand;
    }

    public void setMethodCommand(String methodCommand) {
        this.methodCommand = methodCommand;
    }

    @Override
    public String toString() {
        return "Request{" +
                "mapRequest=" + mapRequest +
                ", methodCommand='" + methodCommand + '\'' +
                '}';
    }
}
