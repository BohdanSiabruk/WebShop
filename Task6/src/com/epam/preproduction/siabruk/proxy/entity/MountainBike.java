package com.epam.preproduction.siabruk.proxy.entity;


import java.util.Objects;

public class MountainBike implements MountBike {

    private int wheelSize;
    private String color;
    private int price;
    private int amountOfSpeed;
    private String suspensionType;
    private boolean onstorage;

    public boolean isOnstorage() {
        return onstorage;
    }

    public void setOnstorage(boolean onstorage) {
        this.onstorage = onstorage;
    }

    public MountainBike() {
    }

    public MountainBike(int wheelSize, String color, int price, int amountOfSpeed, String suspensionType) {
        this.wheelSize = wheelSize;
        this.color = color;
        this.price = price;
        this.amountOfSpeed = amountOfSpeed;
        this.suspensionType = suspensionType;
    }

    @Override
    public int getWheelSize() {
        return wheelSize;
    }

    @Override
    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int getAmountOfSpeed() {
        return amountOfSpeed;
    }

    @Override
    public void setAmountOfSpeed(int amountOfSpeed) {
        this.amountOfSpeed = amountOfSpeed;
    }

    @Override
    public String getSuspensionType() {
        return suspensionType;
    }

    @Override
    public void setSuspensionType(String suspensionType) {
        this.suspensionType = suspensionType;
    }

    @Override
    public String toString() {
        return " MountainBike{ " +
                "amountOfSpeed= " + amountOfSpeed +
                " , suspensionType= '" + suspensionType +
                " , wheelSize " + wheelSize +
                " , price " + price +
                " , color " + color +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) return false;
        MountainBike mountainBike = (MountainBike) o;
        return wheelSize == mountainBike.wheelSize && color == mountainBike.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, color, wheelSize);
    }

}
