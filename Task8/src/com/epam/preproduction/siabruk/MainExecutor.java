package com.epam.preproduction.siabruk;

import com.epam.preproduction.siabruk.constant.Constant;
import com.epam.preproduction.siabruk.threads.CallableAddInGeneralListPieceByPiece;
import com.epam.preproduction.siabruk.threads.CallableAddCollectionToGeneralImmediately;
import com.epam.preproduction.siabruk.util.ConsoleHelper;

import java.util.*;
import java.util.concurrent.*;

public class MainExecutor {
    static List<Integer> integerList;

    public static void main(String[] args) throws Exception {
/**
 * enter rangeFrom, rangeTo, numberThread
 */
        int rangeFrom = ConsoleHelper.inputNumber(Constant.FROM);
        int rangeFrom2 = rangeFrom;
        int rangeTo = ConsoleHelper.inputNumber(Constant.TO + rangeFrom , rangeFrom);
        int numberThread = ConsoleHelper.inputNumber(Constant.AMOUNT_OF_THREAD + (rangeTo - rangeFrom), rangeFrom, rangeTo);
        /**
         * create integer main list
         */

        integerList = Collections.synchronizedList(new ArrayList<>());

        long startTime = new Date().getTime();
/**
 * create pool of executor
 */

        ExecutorService executor = Executors.newFixedThreadPool(numberThread);
/**
 * create list callable
 */
        List<Callable<List<Integer>>> resultList = new ArrayList<>();
/**
 * fill list callable
 */

        for (int i = 0; i < numberThread; i++) {
            resultList.add(new CallableAddCollectionToGeneralImmediately(rangeFrom, rangeTo, numberThread));
            rangeFrom++;
        }

        executor.invokeAll(resultList);

        System.out.println("lists size  = " + integerList.size());

        Collections.sort(integerList);
        integerList.forEach(e -> System.out.print(e + " "));

        executor.shutdown();
        long endTime = new Date().getTime();
        System.out.println();
        System.out.println("time = " + (endTime - startTime));

        //////////////////////////////////////////////////////////////////////

        List<Integer> integerList1 = Collections.synchronizedList(new ArrayList<>());
        long startTime2 = new Date().getTime();

        ExecutorService executor2 = Executors.newFixedThreadPool(numberThread);

        List<Callable<List<Integer>>> callableArrayList = Collections.synchronizedList(new ArrayList<>());


        for (int i = 0; i < numberThread; i++) {
            callableArrayList.add(new CallableAddInGeneralListPieceByPiece(rangeFrom2, rangeTo, numberThread));
            rangeFrom2++;
        }
        List<Future<List<Integer>>> resultList2 = executor2.invokeAll(callableArrayList);

        for (Future<List<Integer>> future : resultList2) {
            integerList1.addAll(future.get());
        }

        Collections.sort(integerList1);
        integerList1.forEach(e -> System.out.print(e + " "));

        executor2.shutdown();

        long endTime2 = new Date().getTime();
        System.out.println();
        System.out.println("time = " + (endTime2 - startTime2));
    }

    public static List<Integer> getIntegerList() {
        return integerList;
    }
}
