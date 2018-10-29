package com.epam.preproduction.siabruk;

import com.epam.preproduction.siabruk.constant.Constant;
import com.epam.preproduction.siabruk.threads.ThreadAddToGeneralListImmediately;
import com.epam.preproduction.siabruk.threads.ThreadAddCollectionToGeneralPieceByPiece;
import com.epam.preproduction.siabruk.util.ConsoleHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class MainThread {


    public static void main(String[] args) throws IOException, InterruptedException {
        ArrayList<Integer> listSimpleNumber = new ArrayList<>();

        int rangeFrom = ConsoleHelper.inputNumber(Constant.FROM);
        int rangeTo = ConsoleHelper.inputNumber(Constant.TO, rangeFrom);
        int numberThread = ConsoleHelper.inputNumber(Constant.AMOUNT_OF_THREAD, rangeFrom, rangeTo);

        long startTime = new Date().getTime();

        Thread[] threads = new Thread[numberThread];
        ThreadAddToGeneralListImmediately threadAddToGeneralListImmediately;

        int y = rangeFrom;

        for (int i = 0; i < numberThread; i++) {
            threadAddToGeneralListImmediately = new ThreadAddToGeneralListImmediately(y, rangeTo, numberThread, listSimpleNumber);
            threads[i] = threadAddToGeneralListImmediately;
            y++;
        }

        for (Thread t : threads) {
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("end");

        listSimpleNumber.stream().sorted().forEach(e -> System.out.print(e + " "));

        System.out.println();
        long endTime = new Date().getTime();

        System.out.println("time ==> " + (endTime - startTime));

        listSimpleNumber.clear();

        //////////////////////////////////////////////////////////////////////////
        // with temporally list


        long startTimeWith = new Date().getTime();

        int copyRange = rangeFrom;

        Thread[] threads2 = new Thread[numberThread];
        ThreadAddCollectionToGeneralPieceByPiece threadAddCollectionToGeneralPieceByPiece;
        for (int i = 0; i < numberThread; i++) {
            threadAddCollectionToGeneralPieceByPiece = new ThreadAddCollectionToGeneralPieceByPiece(copyRange, rangeTo, numberThread, listSimpleNumber);
            threads2[i] = threadAddCollectionToGeneralPieceByPiece;
            copyRange++;
        }

        for (Thread t : threads2) {
            t.start();
        }

        for (Thread t : threads2) {
            t.join();
        }

        System.out.println("end");

        listSimpleNumber.stream().sorted().forEach(e -> System.out.print(e + " "));

        System.out.println();
        long endTimeWith = new Date().getTime();

        System.out.println("time ==> " + (endTimeWith - startTimeWith));
    }
}
