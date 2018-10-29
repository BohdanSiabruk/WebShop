package com.epam.preproduction.siabruk.entity;

import java.util.Objects;

public class Bicycle {

    private int wheelSize;
    private String color;
    private int price;

    Bicycle() {
    }

    public Bicycle(int wheelSize, String color, int price) {
        this.wheelSize = wheelSize;
        this.color = color;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWheelSize() {
        return wheelSize;
    }

    public void setWheelSize(int wheelSize) {
        this.wheelSize = wheelSize;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "wheelSize=" + wheelSize +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bicycle bicycle = (Bicycle) o;
        return wheelSize == bicycle.wheelSize &&
                price == bicycle.price &&
                Objects.equals(color, bicycle.color);
    }
}
