package com.epam.preproduction.siabruk.threads;

import com.epam.preproduction.siabruk.util.Util;

import java.util.ArrayList;
import java.util.List;


public class ThreadAddCollectionToGeneralPieceByPiece extends Thread {

    private int rangeFrom;
    private int rangeTo;
    private int numberThread;
    private List<Integer> integerList;

    public ThreadAddCollectionToGeneralPieceByPiece(int rangeFrom, int rangeTo, int numberThread, List<Integer> integerList) {
        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
        this.numberThread = numberThread;
        this.integerList = integerList;
    }

    @Override
    public void run() {
        List<Integer> list = new ArrayList<>();
        synchronized (this) {
            Util.addToIntegerList(rangeFrom, rangeTo, numberThread, list);
            integerList.addAll(list);
        }
    }
}
