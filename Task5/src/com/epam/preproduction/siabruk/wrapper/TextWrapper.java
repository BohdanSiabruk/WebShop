package com.epam.preproduction.siabruk.wrapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TextWrapper {
    private String fileName;
    List<String> lines;

    public TextWrapper(String fileName) {
        this.fileName = fileName;
    }

    public void readFile() throws IOException {
        lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
    }

    public void printLine() {
        for (String line : lines) {
            System.out.println(line);
        }
    }

    public List<String> getLines() {
        return lines;
    }
}