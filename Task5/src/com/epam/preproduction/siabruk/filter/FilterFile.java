package com.epam.preproduction.siabruk.filter;

import java.io.IOException;
import java.text.ParseException;

public abstract class FilterFile {

    FilterFile next;

    public void setNext(FilterFile next) {
        this.next = next;
    }

    abstract public void sortFile() throws IOException, ParseException;


}
