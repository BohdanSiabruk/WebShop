package com.epam.preproduction.siabruk.proxy.proxy.factory;

import com.epam.preproduction.siabruk.proxy.entity.MountBike;

public abstract class MountainBikeProxyFactory {
    public abstract MountBike createMountainBike(MountBike mountBike) throws IllegalAccessException;
}
