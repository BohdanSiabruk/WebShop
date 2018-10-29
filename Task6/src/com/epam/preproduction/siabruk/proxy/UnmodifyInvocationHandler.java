package com.epam.preproduction.siabruk.proxy;

import com.epam.preproduction.siabruk.proxy.entity.MountBike;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UnmodifyInvocationHandler implements InvocationHandler {

    private MountBike mountBike;

    public UnmodifyInvocationHandler(MountBike mountBike) {
        this.mountBike = mountBike;
    }

       @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("set")) {
            throw new UnsupportedOperationException();
        }
        return method.invoke(mountBike, args);
    }

}
