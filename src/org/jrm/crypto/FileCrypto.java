package org.jrm.crypto;

/**
 * Class model for FileCrypto
 * @author Jared R Mallas
 * @version 1.0
 */
public class FileCrypto
{
    private String cryptoKey;

    /**
     * Constructor for FileCrypto
     * @param cryptoKey String required to encrypt or decrypt (use same key for both)
     */
    public FileCrypto(String cryptoKey)
    {
        this.cryptoKey = cryptoKey;
    }

    /**
     * Method to "encrypt" a given string.
     * This method relies on "character math." As each java 'char' primitive has an
     * integer value, it is possible to "do math" on them. This method will iterate
     * through the given string in order to do 'char math' upon each. The 'char math'
     * in question is to add the int value of a different character to the original.
     * To make things less predictable, I take the value of cryptoKey (set through
     * the constructor) and iterate through that in order to determine what value to
     * add to each char. Once I have iterated through the entire string of cryptoKey
     * I just start at the beginning again.
     * @param someText String value that you want to 'encrypt'
     * @return new String with the 'encrypted' result of someText
     */
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

    /**
     * Method to "decrypt" a given string.
     * This method relies on "character math." Since each java 'char' primitive has an
     * integer value, it is possible to "do math" on them. This method will iterate
     * through the given string in order to do 'char math' upon each. The 'char math'
     * in question is to subtract the int value of a different character from the original.
     * To make things less predictable, I take the value of cryptoKey (set through
     * the constructor) and iterate through that in order to determine what value to
     * subtract from each char. Once I have iterated through the entire string of cryptoKey
     * I just start at the beginning again.
     * @param someText String value that you want to 'decrypt'
     * @return new String with the 'encrypted' result of someText
     */
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
}
