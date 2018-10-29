package com.epam.preproduction.siabruk.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class UtilMainSearch {

    private UtilMainSearch() {
    }



    public static String getTextFromFie(String fileName) {
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String s;
            while ((s = br.readLine()) != null) {

                stringBuffer.append(s);
            }
        } catch (IOException ex) {

            System.out.println(ex.getMessage());
        }
        return stringBuffer.toString();
    }

    public static List<Byte> returnByteList(String text) {
        List<Byte> byteList = new ArrayList<>();
        byte[] bytes = text.getBytes();

        for (Byte b : bytes) {
            byteList.add(b);
        }
        return byteList;
    }

    public static boolean isContains(int rangeFrom, List<Byte> byteList, List<Byte> currentCombinaytion) {
        List<Byte> subList = byteList.subList(rangeFrom, byteList.size());
        if (rangeFrom == (byteList.size()) || (subList.size() < currentCombinaytion.size())) {
            return false;
        } else {
            return containsAllByte(subList, currentCombinaytion);
        }
    }

    private static boolean containsAllByte(List<Byte> subList, List<Byte> currentCombination) {
        int count = 0;
        int state = 0;
        for (int i = 0; i < subList.size(); i++) {
                   if (subList.get(i) == currentCombination.get(count)) {
                state = 1;

                if (count != currentCombination.size() - 1) {
                    count++;
                } else if (count == currentCombination.size() - 1) {
                    return true;
                }
            } else {
                if (state == 1 && currentCombination.size() > (subList.size() - i - 1)) {
                    return false;
                }
                count = 0;
                state = 0;
            }
        }
        return false;
    }

    public static List<Integer> findStart(String text, String patern){
        List<Integer> listStartValue = new ArrayList<>();

        Pattern pattern = Pattern.compile(patern);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            listStartValue.add(matcher.start());
        }
        return listStartValue;
    }

    public static String returnStringFromByte(List<Byte> byteList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : byteList) {
            char c = (char) b;
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
