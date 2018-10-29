package com.epam.preproduction.siabruk.helper;

import com.epam.preproduction.siabruk.constant.Context;
import com.epam.preproduction.siabruk.entity.Bicycle;

import java.io.*;
import java.util.Map;

public final class SerializableHelper {

    private SerializableHelper() {
    }

    public static void writeFile(Map<Bicycle, Integer> bicycleList) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(Context.FILENAME + ".txt");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(bicycleList);
        }
    }

    public static Map<Bicycle, Integer> readFile() throws IOException, ClassNotFoundException {

        Map<Bicycle, Integer> bicycleList;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(
                new FileInputStream(Context.FILENAME + ".txt")))) {

            bicycleList = ((Map<Bicycle, Integer>) objectInputStream.readObject());
        }
        return bicycleList;
    }
}
