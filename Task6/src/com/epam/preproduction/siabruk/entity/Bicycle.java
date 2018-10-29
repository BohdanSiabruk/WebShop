package com.epam.preproduction.siabruk.entity;


import com.epam.preproduction.siabruk.reflection.BicycleAnnotation;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Bicycle implements Serializable {
    private static int id = 0;
    @BicycleAnnotation(value = "Bicycle.wheelSize")
    private int wheelSize;
    @BicycleAnnotation(value = "Bicycle.color")
    private String color;
    @BicycleAnnotation(value = "Bicycle.price")
    private BigDecimal price;


    public Bicycle() {
    }

    public Bicycle(int wheelSize, String color, BigDecimal price) {
        this.wheelSize = wheelSize;
        this.color = color;
        this.price = price;
        this.id++;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
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

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return " Bicycle{ " +
                "wheelSize= " + wheelSize +
                ", color='" + color + '\'' +
                ", price = " + price +
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
        Bicycle bicycle = (Bicycle) o;
        return wheelSize == bicycle.wheelSize &&
                price == bicycle.price &&
                Objects.equals(color, bicycle.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wheelSize, color, price);
    }
}
