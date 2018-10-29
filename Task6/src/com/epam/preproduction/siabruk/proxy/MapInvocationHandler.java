package com.epam.preproduction.siabruk.proxy;



import com.epam.preproduction.siabruk.constant.Context;
import com.epam.preproduction.siabruk.proxy.entity.MountBike;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;


import static java.util.Objects.isNull;

public class MapInvocationHandler implements InvocationHandler {


        private Map<String, Object> proxyMap;

        public MapInvocationHandler(MountBike mountBike) throws IllegalAccessException {
            proxyMap = fillMap(mountBike);

        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            String methodName = method.getName();

            if (methodName.startsWith(Context.NAME_OF_METHOD_GET)) {
                return proxyMap.get(methodName.substring(3).toLowerCase());
            } else if (methodName.startsWith(Context.SET)) {
                return proxyMap.put(method.getName().substring(3).toLowerCase(), args[0]);
            } else if (methodName.startsWith(Context.NAME_OF_METHOD_IS)) {

                return proxyMap.get(methodName.substring(2).toLowerCase());
            }
            return method.invoke(proxy, args);
        }

        private Map<String, Object> fillMap(MountBike mountBike) throws IllegalAccessException {

            Map<String, Object> mapFields = new HashMap<>();

            Class clazz = mountBike.getClass();
            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);
                Object value = field.get(mountBike);
                if (isNull(value)) {

                    mapFields.put(field.getName().toLowerCase(), field.get(mountBike));
                }
            }
            return mapFields;
        }
    }
