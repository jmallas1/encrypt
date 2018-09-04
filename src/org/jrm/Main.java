package org.jrm;

import org.jrm.crypto.FileCrypto;
import org.jrm.io.FileInput;
import org.jrm.io.FileOutput;

public class Main {

    public static void main(String[] args)
    {
        FileCrypto fc = new FileCrypto("happykey");

        FileInput fi = new FileInput("secrets.in");
        FileOutput fi = new FileOutput("secrets.out");



    }
}
