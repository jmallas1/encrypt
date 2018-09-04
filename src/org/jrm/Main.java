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
        String deCrypt = "";
        String deCrypted = "";

        try
        {
            FileInput fi = new FileInput("secrets.in");
            toCrypt = fi.readFile();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        toCrypt = fc.encrypt(toCrypt);

        try
        {
            FileOutput fo = new FileOutput("secrets.out");
            fo.writeFile(toCrypt);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        try
        {
            FileInput fi2 = new FileInput("secrets.out");
            deCrypt = fi2.readFile();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        deCrypted = fc.decrypt(deCrypt);

        try
        {
            FileOutput fo = new FileOutput("secrets.decrypted");
            fo.writeFile(deCrypted);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
