package org.jrm.test;

import org.jrm.crypto.FileCrypto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileCryptoTest {

    FileCrypto fc;

    @org.junit.jupiter.api.BeforeEach
    void setUp() { fc = new FileCrypto( "jrm123");}

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @Test
    void decrypt()
    {
        assertEquals("Jared was here", fc.decrypt(fc.encrypt("Jared was here")), "Encrypt decrypt functions");
    }

    @Test
    void encrypt()
    {
        assertNotEquals("Jared was here", fc.encrypt("Jared was here"), "Encrypt turns string to garbage");
    }
}