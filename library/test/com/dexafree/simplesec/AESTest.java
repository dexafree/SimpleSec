package com.dexafree.simplesec;

import junit.framework.TestCase;

public class AESTest extends TestCase {

    private final static String KEY = "MY_SECRET";

    public void testMethods() throws Exception {
        String expected = "Hello";

        String encoded = AES.encrypt(expected, KEY);
        
        //System.out.println("ENCODED: "+encoded);

        String decoded = AES.decrypt(encoded, KEY);

        //System.out.println("DECODED: "+decoded);

        assertEquals(decoded, expected);
    }

}