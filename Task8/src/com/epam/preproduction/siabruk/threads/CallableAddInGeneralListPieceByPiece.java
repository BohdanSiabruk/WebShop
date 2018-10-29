package com.epam.preproduction.siabruk.threads;

import com.epam.preproduction.siabruk.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class CallableAddInGeneralListPieceByPiece implements Callable<List<Integer>> {

    private int rangeFrom;
    private int rangeTo;
    private int numberThread;
    private List<Integer> mainList = new ArrayList<>();

    public CallableAddInGeneralListPieceByPiece(int rangeFrom, int rangeTo, int numberThread) {
        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
        this.numberThread = numberThread;

    }

    @Override
    public List<Integer> call() {

        Util.addToIntegerList(rangeFrom, rangeTo, numberThread, mainList);
        return mainList;
    }

    public List<Integer> getMainList() {
        return mainList;
    }
}
