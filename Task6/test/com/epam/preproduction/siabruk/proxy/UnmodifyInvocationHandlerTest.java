package com.epam.preproduction.siabruk.proxy;

import com.epam.preproduction.siabruk.proxy.proxy.factory.MountainBikeProxyFactory;
import com.epam.preproduction.siabruk.proxy.proxy.factory.UnmodifyMountainBikeProxyFactory;
import com.epam.preproduction.siabruk.proxy.entity.MountBike;
import com.epam.preproduction.siabruk.proxy.entity.MountainBike;
import org.junit.Test;

public class UnmodifyInvocationHandlerTest {

    @Test(expected = UnsupportedOperationException.class)
    public void testInvoke() throws IllegalAccessException {
        MountBike bike = new MountainBike();
        bike.setAmountOfSpeed(100);
        bike.setColor("Green");
        bike.setPrice(10_000);
        bike.setSuspensionType("Suspense");
        bike.setWheelSize(29);

        MountainBikeProxyFactory proxyFactory = new UnmodifyMountainBikeProxyFactory();
        MountBike unmBike = proxyFactory.createMountainBike(bike);

        unmBike.setWheelSize(10);
    }
}