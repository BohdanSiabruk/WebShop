package com.epam.preproduction.siabruk.builder.impl;

import com.epam.preproduction.siabruk.entity.Bicycle;
import com.epam.preproduction.siabruk.entity.ElectricalMountainBike;
import com.epam.preproduction.siabruk.strategy.BicycleStrategy;

import java.io.IOException;

import static java.util.Objects.isNull;

public class ElectricalMountainBieBuilder extends MountainBikeBuilder {

    public ElectricalMountainBieBuilder(BicycleStrategy bicycleStrategy) {
        super(bicycleStrategy);
    }

    @Override
    public Bicycle createBicycle() throws IOException {

        if (isNull(getBicycle())) {
            setBicycle(new ElectricalMountainBike());
        }

        ElectricalMountainBike electricalMountainBike = (ElectricalMountainBike) super.createBicycle();

        electricalMountainBike.setMaxSpeed(getBicycleStrategy().getMaxSpeed());
        electricalMountainBike.setWorkTime(getBicycleStrategy().getWorkTime());


        return electricalMountainBike;
    }
}
