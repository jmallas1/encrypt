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
        char[] keyArrayOfChars = cryptoKey.toCharArray();
        int keyArrayCount = keyArrayOfChars.length;
        int keyCounter = 0;
        char workingChar = 0;

        char[] toCrypt = someText.toCharArray();
        int cryptCounter = 0;

        String rString = new String();

        for(char aChar : toCrypt)
        {
            workingChar =  (char) (aChar - keyArrayOfChars[keyCounter]);

            rString += Character.toString(workingChar);

            cryptCounter++;
            keyCounter++;
            if(keyCounter == keyArrayCount)
            {
                keyCounter = 0;
            }
        }

        return rString;
    }

    public String encrypt(String someText)
    {
        char[] keyArrayOfChars = cryptoKey.toCharArray();
        int keyArrayCount = keyArrayOfChars.length;
        int keyCounter = 0;
        char workingChar = 0;

        char[] toCrypt = someText.toCharArray();
        int cryptCounter = 0;

        String rString = new String();

        for(char aChar : toCrypt)
        {
            // workingChar =  (char) (aChar + 10);
            workingChar =  (char) (aChar + keyArrayOfChars[keyCounter]);

            rString += Character.toString(workingChar);

            cryptCounter++;
            keyCounter++;
            if(keyCounter == keyArrayCount)
            {
                keyCounter = 0;
            }
        }

        return rString;
    }
}
