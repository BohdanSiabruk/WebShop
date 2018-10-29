package com.epam.preproduction.siabruk;

import com.epam.preproduction.siabruk.container.Container;
import com.epam.preproduction.siabruk.filter.*;

import java.io.IOException;
import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        Container.addFolder();

        Container.loadList();

        FilterCheinBuilder filterCheinBuilder = new FilterCheinBuilder();

        filterCheinBuilder.createMapOfFilter();
        filterCheinBuilder.selectFilter();
        filterCheinBuilder.setFilterChein();

        Container.printResult();
    }
}
