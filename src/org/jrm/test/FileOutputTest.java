package org.jrm.test;

import org.jrm.io.FileOutput;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class FileOutputTest {

    FileOutput fo = null;
    @BeforeEach
    void setUp()
    {
        try
        {
            fo = new FileOutput("./foTest.out");
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    @AfterEach
    void tearDown()
    {
        new File("./foTest.out").delete();
    }

    @DisplayName("Test that you can write a file")
    @Test
    void writeFile()
    {
        fo.writeFile("This is a file");
        assertTrue((new File("./foTest.out").exists()));
    }
}