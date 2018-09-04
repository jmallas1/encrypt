package org.jrm.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileInput
{
    String filePath;
    private BufferedReader in = null;

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

    public String readFile() throws IOException
    {
        String rString = new String();
        String line;
        try
        {
            while ((line = in.readLine()) != null)
            {
                rString += line;
            }
        }
        catch (Exception e)
        {
            System.out.println("File Read Error: " + filePath + " " + e);
            throw e;
        }

        return rString;
    }

    public String readNextLine() throws IOException
    {
        try
        {
            return in.readLine();
        }
        catch (Exception e)
        {
            System.out.println("File Read Error: " + filePath + " " + e);
            throw e;
        }
    }

}
