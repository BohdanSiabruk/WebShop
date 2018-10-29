package com.epam.preproduction.siabruk.strategy.impl;

import com.epam.preproduction.siabruk.constant.Context;
import com.epam.preproduction.siabruk.strategy.BicycleStrategy;
import com.epam.preproduction.siabruk.helper.ConsoleHelper;

import java.io.IOException;
import java.math.BigDecimal;

public class ConsoleStrategy implements BicycleStrategy {

    private String language;

    public ConsoleStrategy(String language) {
        this.language = language;
    }

    @Override
    public int getWheelSize() throws IOException {
        System.out.println(ConsoleHelper.resourceBundle(language, "enterWheelSize"));
        return ConsoleHelper.checkAndGetValueInt(language, Context.SIZE_MAX, Context.SIZE_MIN);
    }

    @Override
    public String getColor() throws IOException {
        System.out.println(ConsoleHelper.resourceBundle(language, "enterColor"));
        return ConsoleHelper.checkAndGetValueStr();
    }

    @Override
    public BigDecimal getPrice() throws IOException {
        System.out.println(ConsoleHelper.resourceBundle(language, "enterPrice"));
        return ConsoleHelper.checkAndGetValueBigDec(language, Context.PRICE_MAX, Context.PRICE_MIN);
    }

    @Override
    public int getAmountOfSpeed() throws IOException {
        System.out.println(ConsoleHelper.resourceBundle(language, "enterAmountOfSpeed"));
        return ConsoleHelper.checkAndGetValueInt(language, Context.AMOUNT_OF_SPEED_MAX, Context.AMOUNT_OF_SPEED_MIN);
    }

    @Override
    public String getSuspensionType() throws IOException {
        System.out.println(ConsoleHelper.resourceBundle(language, "enterSuspension"));
        return ConsoleHelper.checkOnEmptyStringAndGet();
    }

    @Override
    public int getMaxSpeed() throws IOException {
        System.out.println(ConsoleHelper.resourceBundle(language, "maxSpeed"));
        return ConsoleHelper.checkAndGetValueInt(language, Context.SPEED_MAX, Context.SPEED_MIN);
    }

    @Override
    public int getWorkTime() throws IOException {
        System.out.println(ConsoleHelper.resourceBundle(language, "enterWorkTime"));
        return ConsoleHelper.checkAndGetValueInt(language, Context.WORKTIME_MAX, Context.WORKTIME_MIN);
    }
}
