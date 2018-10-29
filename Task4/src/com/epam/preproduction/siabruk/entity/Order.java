package com.epam.preproduction.siabruk.entity;


public class Order {

    private int numberOfOder;

    private int oderSum;

    public Order(int numberOfOder, int oderSum) {
        this.numberOfOder = numberOfOder;
        this.oderSum = oderSum;
    }

    public int getOderSum() {
        return oderSum;
    }

    public void setOderSum(int oderSum) {
        this.oderSum = oderSum;
    }

    @Override
    public String toString() {
        return numberOfOder + "number of oder  " + oderSum + " sum of oder";
    }
}
