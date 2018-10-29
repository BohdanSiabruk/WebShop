package com.epam.preproduction.siabruk.threads;

import com.epam.preproduction.siabruk.MainExecutor;

import java.util.List;
import java.util.concurrent.Callable;

import static com.epam.preproduction.siabruk.util.Util.*;

public class CallableAddCollectionToGeneralImmediately implements Callable<List<Integer>> {

    private int rangeFrom;
    private int rangeTo;
    private int numberThread;

    public CallableAddCollectionToGeneralImmediately(int rangeFrom, int rangeTo, int numberThread) {
        this.rangeFrom = rangeFrom;
        this.rangeTo = rangeTo;
        this.numberThread = numberThread;
    }

    @Override
    public List<Integer> call() {
        addToIntegerList(rangeFrom, rangeTo, numberThread, MainExecutor.getIntegerList());
        return null;
    }
}
