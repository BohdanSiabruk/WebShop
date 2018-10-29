package com.epam.preproduction.siabruk.proxy.entity;

public interface MountBike {

    int getWheelSize();

    void setWheelSize(int wheelSize);

    String getColor();

    void setColor(String color);

    int getPrice();

    void setPrice(int price);

    int getAmountOfSpeed();

    void setAmountOfSpeed(int amountOfSpeed);

    String getSuspensionType();

    void setSuspensionType(String suspensionType);

    boolean isOnstorage();

    void setOnstorage(boolean onstorage);
}
