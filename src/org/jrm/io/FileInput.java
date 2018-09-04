package org.jrm.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class model for FileInput
 * @author Jared R Mallas
 * @version 1.0
 */
public class FileInput
{
    String filePath;
    private BufferedReader in = null;

    /**
     * Constructor for FileInput
     * @param filePath String containing a full or relative path to a readable file
     * @throws FileNotFoundException when file is absent or unreadable
     */
    public FileInput(String filePath) throws FileNotFoundException
    {
        this.filePath = filePath;

        try
        {
            in = new BufferedReader(new FileReader(filePath));
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File: " + filePath + " not found");
            throw e;
        }
    }

    /**
     * Method to read an entire file into a String
     * @return String containing the contents of a file
     * @throws IOException when bad stuff happens
     */
    public String readFile() throws IOException
    {
        String rString = new String();
        String line;
        try
        {
            while ((line = in.readLine()) != null)
            {
                rString += line;
                rString += '\n';
            }
            // remove trailing '\n'
            rString = rString.substring(0, rString.length() -1);
        }
        catch (Exception e)
        {
            System.out.println("File Read Error: " + filePath + " " + e);
            throw e;
        }

        return rString;
    }

}
