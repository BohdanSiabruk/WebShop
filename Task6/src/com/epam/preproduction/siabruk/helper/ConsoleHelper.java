package com.epam.preproduction.siabruk.helper;


import com.epam.preproduction.siabruk.builder.BuilderContainer;
import com.epam.preproduction.siabruk.constant.Context;
import com.epam.preproduction.siabruk.service.BicycleService;
import com.epam.preproduction.siabruk.strategy.ChooseStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import static java.util.Objects.isNull;

public final class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    private ConsoleHelper() {
    }

    public static int checkAndGetValueInt(String language, int max, int min) throws IOException {


        String choice = null;
        boolean flag = true;

        while (flag) {

            String choiceStr = bufferedReader.readLine();
            if (!choiceStr.equals("") && choiceStr.matches("[\\d]*") &&
                    Integer.parseInt(choiceStr) >= min && Integer.parseInt(choiceStr) <= max) {
                choice = choiceStr;
                flag = false;

            } else {
                System.out.println(ConsoleHelper.resourceBundle(language, "wrongData"));
            }
        }
        return Integer.parseInt(choice);
    }

    public static BigDecimal checkAndGetValueBigDec(String language, int max, int min) throws IOException {
        String choice = null;
        boolean flag = true;

        while (flag) {

            String choiceStr = bufferedReader.readLine();
            if (!choiceStr.equals("") && choiceStr.matches("[\\d]*") && (max >= Integer.parseInt(choiceStr)
                    && min <= Integer.parseInt(choiceStr))) {
                choice = choiceStr;
                flag = false;
            } else {
                System.out.println(ConsoleHelper.resourceBundle(language, "wrongData"));
            }
        }
        return BigDecimal.valueOf(Integer.parseInt(choice));
    }

    public static String checkAndGetValueStr() throws IOException {
        String choice = null;
        boolean flag = true;

        while (flag) {

            String choiceStr = bufferedReader.readLine();
            if (!choiceStr.equals("") && choiceStr.matches("[\\D]*")) {
                choice = choiceStr;
                flag = false;
            } else {
                System.out.println("you should enter word");
            }
        }
        return choice;
    }

    public static int checkAndGetValueIntMenu(BicycleService bicycleService) throws IOException {
        String choice = null;
        boolean flag = true;

        while (flag) {

            String choiceStr = bufferedReader.readLine();
            if (choiceStr.matches("[\\d]")) {
                if (bicycleService.getAll().size() >= Integer.parseInt(choiceStr)) {
                    choice = choiceStr;
                    flag = false;
                }

                System.out.println("you should enter data!");
            }
        }
        return Integer.parseInt(choice);
    }

    public static String checkOnEmptyStringAndGet() throws IOException {
        String choiceStr = null;
        boolean flag = true;

        while (flag) {

            choiceStr = bufferedReader.readLine();
            if (!isNull(choiceStr)) {
                flag = false;
            } else {
                System.out.println("you should enter correct data");
            }
        }
        return choiceStr;
    }


    public static String checkValue() throws IOException {
        String choiceNumberOfMenu = null;
        boolean flag = true;
        while (flag) {
            choiceNumberOfMenu = bufferedReader.readLine();
            if (!choiceNumberOfMenu.matches("10|([1-9])")) {
                System.out.println("make correct choice: ");
            }
            flag = false;


        }
        return choiceNumberOfMenu;
    }

    public static String checkEnteringValueChoiceMethod(String msm, ChooseStrategy chooseStrategy) throws IOException {
        System.out.print(msm);
        String choice;
        while (true) {

            choice = bufferedReader.readLine();
            chooseStrategy.createChooseList();
            if (chooseStrategy.getChooseGenerator().get(choice) != null) {
                break;
            } else {
                System.out.println(Context.WRONGINPUT);
            }
        }
        return choice;


    }

    public static String checkAddNewItem(BuilderContainer builderContainer) throws IOException {
        boolean flag = true;
        String choiceStr = null;
        while (flag) {
            choiceStr = bufferedReader.readLine();
            try {
                if (builderContainer.getBuilder(choiceStr.toLowerCase()) != null) {
                    flag = false;
                } else {
                    System.out.println(Context.WRONGINPUT);
                }
            } catch (IllegalArgumentException e) {
                System.out.println(Context.WRONGINPUT);
            }
        }
        return choiceStr.toLowerCase();
    }


    public static Date parseDate() throws IOException {
        String s = bufferedReader.readLine();
        Date date = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try {
            date = formatter.parse(s);
        } catch (ParseException e) {
            System.out.println(Context.WRONGDATE);
            parseDate();
        }
        return date;
    }

    public static String resourceBundle(String language, String text) {
        return ResourceBundle.getBundle("resources", new Locale(language)).getString(text);
    }

    public static String checkLanguage() throws IOException {
        System.out.println(Context.EN_OR_RU);
        String choice;
        while (true) {
            String lang = bufferedReader.readLine();
            if (!isNull(lang) && (lang.toLowerCase().equals("ru") || lang.toLowerCase().equals("en"))) {
                choice = lang;
                break;
            }
            System.out.println(Context.WRONGINPUT);
        }
        return choice;
    }

    public static void closeBufferedReader() throws IOException {
        bufferedReader.close();
    }
}
