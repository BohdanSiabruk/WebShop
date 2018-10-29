package com.epam.preproduction.siabruk.proxy.proxy.factory;

import com.epam.preproduction.siabruk.proxy.MapInvocationHandler;
import com.epam.preproduction.siabruk.proxy.entity.MountBike;

import java.lang.reflect.Proxy;

public class MapMountainBikeProxyFactory extends MountainBikeProxyFactory {

    @Override
    public MountBike createMountainBike(MountBike mountBike) throws IllegalAccessException {
        return (MountBike) Proxy.newProxyInstance(mountBike.getClass().getClassLoader(),
                mountBike.getClass().getInterfaces(), new MapInvocationHandler(mountBike));
    }
}
