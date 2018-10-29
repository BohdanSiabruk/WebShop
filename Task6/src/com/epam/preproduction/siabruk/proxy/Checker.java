package com.epam.preproduction.siabruk.proxy;

import com.epam.preproduction.siabruk.proxy.entity.MountBike;
import com.epam.preproduction.siabruk.proxy.entity.MountainBike;
import com.epam.preproduction.siabruk.proxy.proxy.factory.MapMountainBikeProxyFactory;
import com.epam.preproduction.siabruk.proxy.proxy.factory.MountainBikeProxyFactory;

public class Checker {

    public static void main(String[] args) throws IllegalAccessException {

        MountainBikeProxyFactory mountainBikeProxyFactory = new MapMountainBikeProxyFactory();
        MountBike bike = new MountainBike();
        bike.setAmountOfSpeed(30);

        MountBike mountainBikeProxy = mountainBikeProxyFactory.createMountainBike(bike);

        System.out.println(mountainBikeProxy.getAmountOfSpeed());

    }
}
