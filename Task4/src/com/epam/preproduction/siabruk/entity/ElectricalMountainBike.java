package com.epam.preproduction.siabruk.entity;

public class ElectricalMountainBike extends MountainBike {

    private int maxSpeed;
    private int workTime;

    public ElectricalMountainBike() {
    }

    public ElectricalMountainBike(int wheelSize, String color, int prise, int emountOfSpead, String suspensionType, int maxSpeed) {
        super(wheelSize, color, prise, emountOfSpead, suspensionType);
        this.maxSpeed = maxSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getWorkTime() {
        return workTime;
    }

    public void setWorkTime(int workTime) {
        this.workTime = workTime;
    }

    @Override
    public String toString() {
        return "  ElectricalMountainBike{" +
                "maxSpeed=" + maxSpeed +
                ", workTime=" + workTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ElectricalMountainBike that = (ElectricalMountainBike) o;
        return maxSpeed == that.maxSpeed &&
                workTime == that.workTime;
    }
}
