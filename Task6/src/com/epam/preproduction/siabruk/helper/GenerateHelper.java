package com.epam.preproduction.siabruk.helper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class GenerateHelper {

    private GenerateHelper() {
    }

    public static int generateIntInInterval(int max, int min) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public static BigDecimal generateBigDInInterval(int max, int min) {
        Random random = new Random();
        return BigDecimal.valueOf(random.nextInt((max - min) + 1) + min);
    }

    public static String generateStringColor() {
        Random random = new Random();
        List<String> list = new ArrayList<>();
        list.add("red");
        list.add("blue");
        list.add("white");
        list.add("dark");
        list.add("yellow");
        int x = random.nextInt(4);

        return list.get(x);
    }

    public static String generateStringSuspension() {
        Random random = new Random();
        int x = random.nextInt((2 - 1) + 1) + 1;
        String sus = null;
        switch (x) {
            case 1:
                sus = "suspension";
                break;
            case 2:
                sus = "no suspension";
                break;
        }
        return sus;
    }

}
