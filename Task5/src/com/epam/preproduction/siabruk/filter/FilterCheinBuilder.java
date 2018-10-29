package com.epam.preproduction.siabruk.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterCheinBuilder {

    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    private FilterFile filterByNAme;
    private FilterFile filterByExtension;
    private FilterFile filterBySize;
    private FilterFile filterByLastModify;

    private Map<String, FilterFile> filterFileList = new HashMap<>();
    private List<FilterFile> filterFileListChein = new ArrayList<>();

    private static long fromSize;
    private static long toSize;
    private static long fromSizeTime;
    private static long toSizeTime;
    private static String extension;
    private static String fileName;


    public void setFilterFileListChein(List<FilterFile> filterFileListChein) {
        this.filterFileListChein = filterFileListChein;
    }

    public FilterCheinBuilder() {
        this.filterByNAme = new FilterByName();
        this.filterByExtension = new FilterByExtension();
        this.filterBySize = new FilterBySize();
        this.filterByLastModify = new FilterByLastModify();
    }

    public void createMapOfFilter() {
        filterFileList.put("Do you want sort by name ? (0 / 1)", filterByNAme);
        filterFileList.put("Do you want sort by extension ? (0 / 1)", filterByExtension);
        filterFileList.put("Do you want sort by size ? (0 / 1)", filterBySize);
        filterFileList.put("Do you want sort by last modify ? (0 / 1)", filterByLastModify);
    }

    public void selectFilter() {
        setFilterFileListChein(filterFileList.entrySet().stream().filter(entry -> {
            System.out.println(entry.getKey());
            boolean flag = false;
            if (choice() == 1) {
                switch (entry.getValue().toString()) {

                    case "bySize":
                        try {
                            System.out.println("from");
                            fromSize = Long.parseLong(bufferedReader.readLine());
                            System.out.println("to");
                            toSize = Long.parseLong(bufferedReader.readLine());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        flag = true;
                        break;

                    case "byLastModify":
                        try {
                            System.out.println("from");
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy ss:mm:HH");

                            fromSizeTime = simpleDateFormat.parse(bufferedReader.readLine()).getTime();
                            System.out.println("to");
                            toSizeTime = simpleDateFormat.parse(bufferedReader.readLine()).getTime();
                        } catch (ParseException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        flag = true;
                        break;

                    case "byExtension":
                        System.out.print("enter extension: ");
                        try {
                            extension = bufferedReader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        flag = true;
                        break;

                    case "byName":
                        System.out.println("enter name: ");
                        try {
                            fileName = bufferedReader.readLine();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        flag = true;
                        break;

                }
            }
            return flag;
        }).map(Map.Entry::getValue).collect(Collectors.toList()));
    }

    public void setFilterChein() throws IOException, ParseException {
        for (int i = 0; i < filterFileListChein.size() - 1; i++) {
            filterFileListChein.get(i).setNext(filterFileListChein.get(i + 1));
        }
        if (filterFileListChein.size() != 0) {
            filterFileListChein.get(0).sortFile();
        }
    }

    public int choice() {
        int choiceNumber = 0;
        try {
            choiceNumber = Integer.parseInt(bufferedReader.readLine());
            if (choiceNumber != 0 && choiceNumber != 1) {
                choice();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return choiceNumber;
    }

    public static long getFromSize() {
        return fromSize;
    }

    public static long getToSize() {
        return toSize;
    }

    public static long getFromSizeTime() {
        return fromSizeTime;
    }

    public static long getToSizeTime() {
        return toSizeTime;
    }

    public static String getExtension() {
        return extension;
    }

    public static String getFileName() {
        return fileName;
    }
}
