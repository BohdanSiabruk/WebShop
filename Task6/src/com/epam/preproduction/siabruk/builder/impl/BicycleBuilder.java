package com.epam.preproduction.siabruk.builder.impl;

import com.epam.preproduction.siabruk.builder.BuilderProduct;
import com.epam.preproduction.siabruk.entity.Bicycle;
import com.epam.preproduction.siabruk.strategy.BicycleStrategy;

import java.io.IOException;

import static java.util.Objects.isNull;

public class BicycleBuilder implements BuilderProduct {
    private Bicycle bicycle;
    private BicycleStrategy bicycleStrategy;

    public BicycleBuilder(BicycleStrategy bicycleStrategy) {
        this.bicycleStrategy = bicycleStrategy;
    }

    @Override
    public Bicycle createBicycle() throws IOException {
        if (isNull(bicycle)) {
            bicycle = new Bicycle();
        }

        bicycle.setWheelSize(bicycleStrategy.getWheelSize());
        bicycle.setColor(bicycleStrategy.getColor());
        bicycle.setPrice(bicycleStrategy.getPrice());
        return bicycle;
    }

    public Bicycle getBicycle() {
        return bicycle;
    }

    public void setBicycle(Bicycle bicycle) {
        this.bicycle = bicycle;
    }

    public BicycleStrategy getBicycleStrategy() {
        return bicycleStrategy;
    }

}
