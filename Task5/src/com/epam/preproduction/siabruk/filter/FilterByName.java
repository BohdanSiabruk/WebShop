package com.epam.preproduction.siabruk.filter;

import com.epam.preproduction.siabruk.container.Container;

import java.io.IOException;
import java.text.ParseException;
import java.util.stream.Collectors;

public class FilterByName extends FilterFile {

    @Override
    public void sortFile() throws IOException, ParseException {

        Container.setListFile(Container.getListFile().stream().filter((f) ->
                f.getName().equals(FilterCheinBuilder.getFileName())).collect(Collectors.toList()));

        if (next != null) {
            next.sortFile();
        }
    }

    @Override
    public String toString() {
        return "byName";
    }
}
