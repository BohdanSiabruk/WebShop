package com.epam.preproduction.siabruk.helper;

import com.epam.preproduction.siabruk.entity.Bicycle;
import com.epam.preproduction.siabruk.service.BicycleService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPOutputStream;

public class MultiSerializableHelper {
    private BicycleService bicycleService;

    public MultiSerializableHelper(BicycleService bicycleService) {
        this.bicycleService = bicycleService;
    }

    public void writeNTimes(String fileNameNTimes, int i) throws IOException {

        try (FileOutputStream fileOutputStream = new FileOutputStream(fileNameNTimes);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            for (int y = 0; y < i; y++) {

                objectOutputStream.writeObject(bicycleService.getAll());

            }
        }
    }


    public void writeFileGZip(String fileNameGZip) throws IOException {

        try (ObjectOutputStream oos = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream(fileNameGZip)))) {
            oos.writeObject(bicycleService.getAll());
        }
    }


    public void readFileNTime(String fileName) throws IOException {
        List<Bicycle> listBicycle = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(
                new FileInputStream(fileName)))) {
            boolean flag = true;
            while (flag) {
                try {
                    listBicycle.addAll((ArrayList) objectInputStream.readObject());
                } catch (IOException | ClassNotFoundException e) {
                    flag = false;
                }
            }
        }
    }
}
