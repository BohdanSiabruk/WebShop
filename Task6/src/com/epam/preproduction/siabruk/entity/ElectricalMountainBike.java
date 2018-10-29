package com.epam.preproduction.siabruk.entity;

import com.epam.preproduction.siabruk.reflection.BicycleAnnotation;

import java.math.BigDecimal;

public class ElectricalMountainBike extends MountainBike {
    @BicycleAnnotation(value="ElectricalMountainBike.maxSpeed")
    private int maxSpeed;
    @BicycleAnnotation(value="ElectricalMountainBike.maxSpeed")
    private int workTime;

    public ElectricalMountainBike() {
    }

    public ElectricalMountainBike(int wheelSize, String color, BigDecimal prise, int emountOfSpead, String suspensionType, int maxSpeed, int workTime) {
        super(wheelSize, color, prise, emountOfSpead, suspensionType);
        this.maxSpeed = maxSpeed;
        this.workTime = workTime;
    }


    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }


    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    @Override
    public String toString() {
        return "ElectricalMountainBike{" +
                "maxSpeed=" + maxSpeed +
                ", workTime=" + workTime +
                ", amountOfSpeed= " + getAmountOfSpeed() +
                ", suspensionType= " + getSuspensionType() +
                ", wheelSize= " + getWheelSize() +
                ", price= " + getPrice() +
                ", color= " + getColor() +
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
        ElectricalMountainBike that = (ElectricalMountainBike) o;
        return maxSpeed == that.maxSpeed &&
                workTime == that.workTime;
    }
}
