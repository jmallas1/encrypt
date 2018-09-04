package org.jrm.io;

import java.io.*;

public class FileOutput
{
    String filePath;
    Writer out = null;

    public FileOutput(String filePath) throws FileNotFoundException {
        this.filePath = filePath;

        try
        {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath)));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Unable to open file for write: " + filePath + " "  + e);
            throw e;
        }
    }

    public void writeFile(String toWrite)
    {
        try
        {
            out.write(toWrite);
            out.close();
        }
        catch(Exception e)
        {
            System.out.println("File Write Error: " + filePath + " "  + e);
        }
    }

    public void writeNextLine(){}
}
