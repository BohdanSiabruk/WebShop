package com.epam.preproduction.siabruk;

import com.epam.preproduction.siabruk.dao.impl.BicycleDAOImpl;
import com.epam.preproduction.siabruk.entity.Bicycle;
import com.epam.preproduction.siabruk.entity.MountainBike;
import com.epam.preproduction.siabruk.manager.MenuManager;
import com.epam.preproduction.siabruk.server.servers.BicycleShop;
import com.epam.preproduction.siabruk.service.BicycleService;
import com.epam.preproduction.siabruk.service.impl.BicycleServiceImpl;
import com.epam.preproduction.siabruk.helper.ConsoleHelper;
import com.epam.preproduction.siabruk.constant.Context;
import com.epam.preproduction.siabruk.helper.SerializableHelper;

import java.io.*;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    private static Map<Bicycle, Integer> mapList;

    public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException, IllegalAccessException, InstantiationException {


        File file = new File(Context.FILENAME + ".txt");
        if (!file.exists() || file.length() == 0) {

            SerializableHelper.writeFile(Main.createListProduct());
        }

        try {
            SerializableHelper.readFile();
        } catch (InvalidClassException | StreamCorruptedException er) {
            SerializableHelper.writeFile(createListProduct());
        }

        mapList = SerializableHelper.readFile();
        BicycleDAOImpl bicycleDAO = new BicycleDAOImpl(returnList());
        BicycleService bicycleService = new BicycleServiceImpl(bicycleDAO);

        BicycleShop bicycleShop = new BicycleShop(bicycleService);
        bicycleShop.run();

        MenuManager menuManager = new MenuManager(bicycleService);
        menuManager.menu();


        SerializableHelper.writeFile(bicycleService.getAll());
        bicycleService.getAll().forEach((key, value) -> System.out.println(value
                + " " + key));


        ConsoleHelper.closeBufferedReader();
    }


    public static Map<Bicycle, Integer> createListProduct() {
        Map<Bicycle, Integer> list = new LinkedHashMap<>();
        for (int i = 0; i < 5; i++) {
            MountainBike mountainBike = new MountainBike(26 + i, "red",
                    BigDecimal.valueOf(345 + (i * 2)), 34 + i, "suspense");
            list.put(mountainBike, mountainBike.getId());
        }
        return list;
    }

    private static Map<Bicycle, Integer> returnList() {
        return mapList;
    }
}
