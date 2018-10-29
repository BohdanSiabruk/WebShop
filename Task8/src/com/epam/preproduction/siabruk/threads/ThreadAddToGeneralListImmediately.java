package com.epam.preproduction.siabruk.threads;

import java.util.List;

import static com.epam.preproduction.siabruk.util.Util.addToIntegerList;

public class ThreadAddToGeneralListImmediately extends Thread {

    private int rangeFrom;
    private int rangeTo;
    private int numberThread;
    private List<Integer> integerList;

    public ThreadAddToGeneralListImmediately(int rangeFrom, int rangeTo, int numberThread, List<Integer> integerList) {
        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
        this.numberThread = numberThread;
        this.integerList = integerList;
    }

    @Override
    public void run() {

        synchronized (this){
            addToIntegerList(rangeFrom, rangeTo, numberThread, integerList);
        }
    }
}
