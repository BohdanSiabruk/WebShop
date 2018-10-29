package com.epam.preproduction.siabruk.container;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Container {
    private static List<File> listFile = new ArrayList<>();
    private static String folderPath;

    public static List<File> getListFile() {
        return listFile;
    }

    public static void setListFile(List<File> listFile) {
        Container.listFile = listFile;
    }

    public static void loadList() throws IOException {
        Path source = Paths.get(folderPath);
        listFile = Files.walk(source).filter(Files::isRegularFile).map(Path::toFile).collect(Collectors.toList());
    }

    public static void printResult() {
        listFile.forEach(System.out::println);
    }

    public static void addFolder() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Please, enter directory: ");
        folderPath = bufferedReader.readLine();
    }
}
