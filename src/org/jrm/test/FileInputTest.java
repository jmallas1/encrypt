package org.jrm.test;


import org.jrm.io.FileInput;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileInputTest {

    FileInput fi = null;

    @BeforeEach
    void setUp()
    {
        try
        {
            fi = new FileInput("./src/org/jrm/test/FileInputTest.java");
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    @AfterEach
    void tearDown() {
    }

    @DisplayName("Test that you can read a file")
    @Test
    void readFile()
    {
        assertThrows(IOException.class, ()->{ new FileInput("C:\\junk"); });
        try
        {
            assertEquals("package org.jrm.test;", fi.readFile().substring(0,21), "File should contain import statement");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}