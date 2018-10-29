package com.epam.preproduction.siabruk.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util {
    public static String checkAndGetValueInt() throws IOException {
BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String choice = null;
        boolean flag = true;

        while (flag) {

            String choiceStr = bufferedReader.readLine();
            if (choiceStr.matches("[\\d]*")) {
                choice = choiceStr;
                flag = false;
            } else {
                System.out.println("you should enter numeric");
            }
        }
        return choice;
    }
}
