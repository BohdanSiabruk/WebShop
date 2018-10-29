package com.epam.preproduction.siabruk.util;

import java.util.List;

public final class Util {

    private Util() {
    }

    private static boolean isSimpleNumber(int value) {

        if (value == 1) {
            return false;
        }
        for (int i = 2; i <= value / 2; i++) {
            if (value == 1 || value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static synchronized void addToIntegerList(int rangeFrom, int rangeTo, int numberThread, List<Integer> integerList) {

        for (int i = rangeFrom; i <= rangeTo; i += numberThread) {
            if (isSimpleNumber(i)) {
                integerList.add(i);
            }
        }
    }
}
