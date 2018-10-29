package com.epam.preproduction.siabruk.proxy;

import com.epam.preproduction.siabruk.proxy.proxy.factory.MapMountainBikeProxyFactory;
import com.epam.preproduction.siabruk.proxy.proxy.factory.MountainBikeProxyFactory;
import com.epam.preproduction.siabruk.proxy.entity.MountBike;
import com.epam.preproduction.siabruk.proxy.entity.MountainBike;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;


public class MapInvocationHandlerTest {

    @Test
    public void testInvoke() throws IllegalAccessException {

        MountainBikeProxyFactory proxyFactory = new MapMountainBikeProxyFactory();
        MountBike unmBike = proxyFactory.createMountainBike(new MountainBike());

        unmBike.setWheelSize(10);
        System.out.println(unmBike.getWheelSize());
        assertNotNull(unmBike.getWheelSize());

    }
}