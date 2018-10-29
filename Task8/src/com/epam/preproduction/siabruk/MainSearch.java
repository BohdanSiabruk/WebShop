package com.epam.preproduction.siabruk;

import com.epam.preproduction.siabruk.util.ConsoleHelper;
import com.epam.preproduction.siabruk.util.UtilMainSearch;

import java.io.IOException;
import java.util.*;

public class MainSearch {
    private static final Object monitor = new Object();
    private static String fileName;
    private static List<Byte> listByte = new ArrayList<>();
    private static List<List<Byte>> resultList = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException, IOException {

        while (true) {

            final ThreadSearch threadSearch = new ThreadSearch();

            Thread t1 = new Thread(() -> {
                try {
                    threadSearch.searchByte();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });


            t1.start();
            System.out.println(Thread.currentThread().getName() + "  " + Thread.currentThread().getState());

            Thread.sleep(1000);

            synchronized (monitor) {
                fileName = ConsoleHelper.getNameOfFile();
                monitor.notify();

                Thread.sleep(1000);
            }
            t1.join();
        }
    }

    private static class ThreadSearch {

        private void searchByte() throws InterruptedException {
            synchronized (monitor) {
                System.out.println("waiting for input name of file");

                monitor.wait();
                System.out.println("file was entered");

                String text = UtilMainSearch.getTextFromFie(fileName);
                listByte = UtilMainSearch.returnByteList(text);
                find(listByte);
                resultList.sort(Comparator.comparingInt(List::size));
                List<Integer> listEnterByte = UtilMainSearch.findStart(text, UtilMainSearch.returnStringFromByte(resultList.get(resultList.size() - 1)));
                System.out.println(resultList.get(resultList.size() - 1));
                System.out.println("first enter = " + listEnterByte.get(0));
                System.out.println("combination = " + UtilMainSearch.returnStringFromByte(resultList.get(resultList.size() - 1)));
                System.out.println("second enter = " + listEnterByte.get(1));
                resultList.clear();
                listByte.clear();

            }
        }
    }

    private static void find(List<Byte> byteListInFind) throws InterruptedException {
        int y = 0;
        for (int i = 0; i < byteListInFind.size(); i++) {
            find2(i);
            if (y == i) {
                resultList.sort(Comparator.comparingInt(List::size));
                System.out.println("current size = " + resultList.get(resultList.size() - 1).size() + "        current combination = " + UtilMainSearch.returnStringFromByte(resultList.get(resultList.size() - 1)));
                y += byteListInFind.size() * 0.1;
                Thread.sleep(400);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static void find2(int number) {
        int state = number;
        List<Byte> currentRange = new ArrayList<>();
        boolean flag = true;

        number++;
        while (flag) {

            for (int i = number; i < listByte.size(); i++) {
                currentRange.add(listByte.get(state));
                if (UtilMainSearch.isContains(state + 1, listByte, currentRange)) {
                    resultList.add((List<Byte>) ((ArrayList<Byte>) currentRange).clone());
                    state++;
                } else {
                    currentRange.clear();
                    flag = false;
                    break;
                }
            }
            if (state == listByte.size() - 1) {
                flag = false;
            }
        }
    }
}
