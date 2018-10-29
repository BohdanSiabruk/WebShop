package com.epam.preproduction.siabruk.strategy.impl;

import com.epam.preproduction.siabruk.strategy.BicycleStrategy;
import com.epam.preproduction.siabruk.constant.Context;
import com.epam.preproduction.siabruk.helper.GenerateHelper;

import java.math.BigDecimal;

public class GenerateStrategy implements BicycleStrategy {

    @Override
    public BigDecimal getPrice() {
        return GenerateHelper.generateBigDInInterval(Context.PRICE_MAX, Context.PRICE_MIN);
    }

    @Override
    public int getWheelSize() {
        return GenerateHelper.generateIntInInterval(Context.SIZE_MAX, Context.SIZE_MIN);
    }

    @Override
    public String getColor() {
        return GenerateHelper.generateStringColor();
    }

    @Override
    public int getAmountOfSpeed() {
        return GenerateHelper.generateIntInInterval(Context.AMOUNT_OF_SPEED_MAX, Context.AMOUNT_OF_SPEED_MIN);
    }

    @Override
    public String getSuspensionType() {
        return GenerateHelper.generateStringSuspension();
    }

    @Override
    public int getMaxSpeed() {
        return GenerateHelper.generateIntInInterval(Context.SPEED_MAX, Context.SPEED_MIN);
    }

    @Override
    public int getWorkTime() {
        return GenerateHelper.generateIntInInterval(Context.WORKTIME_MAX, Context.WORKTIME_MIN);
    }
}
