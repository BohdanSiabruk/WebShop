package com.epam.preproduction.siabruk.util;

import com.epam.preproduction.siabruk.constant.Constant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class ConsoleHelper {
    private ConsoleHelper() {
    }

    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static int inputNumber(String message) throws IOException {

        System.out.println(message);

        String choice = null;
        boolean flag = true;

        while (flag) {

            String choiceStr = bufferedReader.readLine();
            if (!choiceStr.equals("") && choiceStr.matches("[\\d]*")) {
                choice = choiceStr;
                flag = false;

            } else {
                System.out.println(Constant.WRONG_NUMERIC);
            }
        }
        return Integer.parseInt(choice);
    }

    public static int inputNumber(String message, int from) throws IOException {

        System.out.println(message);

        String choice = null;
        boolean flag = true;

        while (flag) {

            String choiceStr = bufferedReader.readLine();
            if (!choiceStr.equals("") && choiceStr.matches("[\\d]*") && Integer.parseInt(choiceStr) > from) {
                choice = choiceStr;
                flag = false;

            } else {
                System.out.println(Constant.WRONG_NUMERIC);
            }
        }
        return Integer.parseInt(choice);
    }

    public static int inputNumber(String message, int from, int to) throws IOException {

        System.out.println(message);

        String choice = null;
        boolean flag = true;

        while (flag) {

            String choiceStr = bufferedReader.readLine();
            if (!choiceStr.equals("") && choiceStr.matches("[\\d]*") && Integer.parseInt(choiceStr) <= (to - from)) {
                choice = choiceStr;
                flag = false;

            } else {
                System.out.println(Constant.WRONG_NUMERIC);
            }
        }
        return Integer.parseInt(choice);
    }

    public static String getNameOfFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(Constant.INPUT_FILE_NAME);
        boolean flag = true;
        String s = "";
        while (flag) {
            s = bufferedReader.readLine();
            if (s.matches("[\\S]*(.txt)")) {
                flag = false;
            } else {
                System.out.println(Constant.WRONG_FILENAME);
            }
        }
        return s;
    }

}
