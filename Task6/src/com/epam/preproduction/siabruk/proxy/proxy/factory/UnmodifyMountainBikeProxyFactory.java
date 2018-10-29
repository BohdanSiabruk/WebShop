package com.epam.preproduction.siabruk.proxy.proxy.factory;

import com.epam.preproduction.siabruk.proxy.UnmodifyInvocationHandler;
import com.epam.preproduction.siabruk.proxy.entity.MountBike;
import com.epam.preproduction.siabruk.proxy.entity.MountainBike;

import java.lang.reflect.Proxy;

public class UnmodifyMountainBikeProxyFactory extends MountainBikeProxyFactory {

    @Override
    public MountBike createMountainBike(MountBike mountBike) {
        return (MountBike) Proxy.newProxyInstance(MountainBike.class.getClassLoader(),
                MountainBike.class.getInterfaces(), new UnmodifyInvocationHandler(mountBike));
    }
}
