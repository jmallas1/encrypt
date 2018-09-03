package org.jrm.crypto;

public class FileCrypto
{
    private String cryptoKey;

    public FileCrypto(String cryptoKey)
    {
        this.cryptoKey = cryptoKey;
    }

    public String decrypt(String someText)
    {

        String rString = someText;

        return rString;
    }

    public String encrypt(String someText)
    {
        return someText;
    }
}
