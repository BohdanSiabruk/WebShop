package com.epam.preproduction.siabruk;

import com.epam.preproduction.siabruk.entity.Bicycle;
import com.epam.preproduction.siabruk.wrapper.CommonWrapper;
import com.epam.preproduction.siabruk.wrapper.WrapperString;
import com.epam.preproduction.siabruk.wrapper.WrapperSumNumbers;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        String a = "onea";
        String a1 = "twoad";
        String a2 = "thre";
        String a3 = "fourfff";
        String a4 = "fifef";

        Bicycle bicycle = new Bicycle(26, "red", 34);
        Bicycle bicycle1 = new Bicycle(27, "dark", 35);
        Bicycle bicycle2 = new Bicycle(28, "white", 36);
        Bicycle bicycle3 = new Bicycle(29, "blue", 37);
        Bicycle bicycle4 = new Bicycle(30, "grey", 38);

        WrapperString key1 = new WrapperString(a);
        WrapperString key2 = new WrapperString(a1);
        WrapperString key3 = new WrapperString(a2);
        WrapperString key4 = new WrapperString(a3);
        WrapperString key5 = new WrapperString(a4);

        WrapperSumNumbers key01 = new WrapperSumNumbers(a);
        WrapperSumNumbers key02 = new WrapperSumNumbers(a1);
        WrapperSumNumbers key03 = new WrapperSumNumbers(a2);
        WrapperSumNumbers key04 = new WrapperSumNumbers(a3);
        WrapperSumNumbers key05 = new WrapperSumNumbers(a4);

        Map<CommonWrapper, Bicycle> mapStringHashMap = new HashMap<>();

        mapStringHashMap.put(key1, bicycle);
        mapStringHashMap.put(key2, bicycle1);
        mapStringHashMap.put(key3, bicycle2);
        mapStringHashMap.put(key4, bicycle3);
        mapStringHashMap.put(key5, bicycle4);

        Map<CommonWrapper, Bicycle> mapSumHahMap = new HashMap<>();

        mapSumHahMap.put(key01, bicycle);
        mapSumHahMap.put(key02, bicycle1);
        mapSumHahMap.put(key03, bicycle2);
        mapSumHahMap.put(key04, bicycle3);
        mapSumHahMap.put(key05, bicycle4);

        Map<CommonWrapper, Bicycle> mapSrtingLinkedMap = new LinkedHashMap<>();

        mapSrtingLinkedMap.put(key1, bicycle);
        mapSrtingLinkedMap.put(key2, bicycle1);
        mapSrtingLinkedMap.put(key3, bicycle2);
        mapSrtingLinkedMap.put(key4, bicycle3);
        mapSrtingLinkedMap.put(key5, bicycle4);

        Map<CommonWrapper, Bicycle> mapSumLinkedMap = new LinkedHashMap<>();

        mapSumLinkedMap.put(key01, bicycle);
        mapSumLinkedMap.put(key02, bicycle1);
        mapSumLinkedMap.put(key03, bicycle2);
        mapSumLinkedMap.put(key04, bicycle3);
        mapSumLinkedMap.put(key05, bicycle4);


        mapSrtingLinkedMap.forEach((key, value) -> System.out.println(key + " ==> " + value));
        System.out.println();
        mapStringHashMap.forEach((key, value) -> System.out.println(key + " ==> " + value));
        System.out.println();
        mapSumHahMap.forEach((key, value) -> System.out.println(key + " ==> " + value));
        System.out.println();
        mapSumLinkedMap.forEach((key, value) -> System.out.println(key + " ==> " + value));

    }
}
