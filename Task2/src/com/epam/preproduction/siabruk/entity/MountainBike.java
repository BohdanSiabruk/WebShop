package com.epam.preproduction.siabruk.entity;

import java.util.Objects;

public class MountainBike extends Bicycle {

    private int amountOfSpeed;
    private String suspensionType;

    public MountainBike() {
    }

    public MountainBike(int wheelSize, String color, int prise, int amountOfSpeed, String suspensionType) {
        super(wheelSize, color, prise);
        this.amountOfSpeed = amountOfSpeed;
        this.suspensionType = suspensionType;
    }

    public int getAmountOfSpeed() {
        return amountOfSpeed;
    }

    public void setAmountOfSpeed(int amountOfSpeed) {
        this.amountOfSpeed = amountOfSpeed;
    }

    public String getSuspensionType() {
        return suspensionType;
    }

    public void setSuspensionType(String suspensionType) {
        this.suspensionType = suspensionType;
    }

    @Override
    public String toString() {
        return "MountainBike{" +
                "amountOfSpeed=" + amountOfSpeed +
                ", suspensionType='" + suspensionType + '\'' +
                "wheelSize " + getWheelSize() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MountainBike that = (MountainBike) o;
        return amountOfSpeed == that.amountOfSpeed &&
                Objects.equals(suspensionType, that.suspensionType);
    }


}
