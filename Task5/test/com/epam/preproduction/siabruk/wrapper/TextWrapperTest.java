package com.epam.preproduction.siabruk.wrapper;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class TextWrapperTest {

    @Test
    public void testReadFile() throws IOException {
        TextWrapper textWrapper = new TextWrapper("direct/text.txt");
        textWrapper.readFile();

        assertNotNull("file not load",textWrapper.getLines());
    }
}