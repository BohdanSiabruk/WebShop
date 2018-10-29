package com.epam.preproduction.siabruk.builder.impl;

import com.epam.preproduction.siabruk.entity.Bicycle;
import com.epam.preproduction.siabruk.entity.MountainBike;
import com.epam.preproduction.siabruk.strategy.BicycleStrategy;

import java.io.IOException;

import static java.util.Objects.isNull;

public class MountainBikeBuilder extends BicycleBuilder {

    public MountainBikeBuilder(BicycleStrategy bicycleStrategy) {
        super(bicycleStrategy);
    }


    @Override
    public Bicycle createBicycle() throws IOException {
        if (isNull(getBicycle())) {
            setBicycle(new MountainBike());
        }
        MountainBike mountainBike = (MountainBike) super.createBicycle();


        mountainBike.setAmountOfSpeed(getBicycleStrategy().getAmountOfSpeed());
        mountainBike.setSuspensionType(getBicycleStrategy().getSuspensionType());


        return mountainBike;
    }
}
