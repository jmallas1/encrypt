package org.jrm;

import org.jrm.crypto.FileCrypto;
import org.jrm.io.FileInput;
import org.jrm.io.FileOutput;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args)
    {
        FileCrypto fc = new FileCrypto("happykey");
        String toCrypt = "";

        try
        {
            FileInput fi = new FileInput("secrets.in");
            toCrypt = fi.readFile();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        try
        {
            FileOutput fo = new FileOutput("secrets.out");
            fo.writeFile(toCrypt);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        System.out.println(toCrypt);

    }
}
