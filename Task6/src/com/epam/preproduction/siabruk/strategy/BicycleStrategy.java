package com.epam.preproduction.siabruk.strategy;

import java.io.IOException;
import java.math.BigDecimal;

public interface  BicycleStrategy {

    BigDecimal getPrice() throws IOException;

    int getWheelSize() throws IOException;

    String getColor() throws IOException;

    int getAmountOfSpeed() throws IOException;

    String getSuspensionType() throws IOException;

    int getMaxSpeed() throws IOException;

    int getWorkTime() throws IOException;

}
