package com.dexafree.simplesec;

import junit.framework.TestCase;

public class AES256Test extends TestCase {

    private final static String KEY = "MY_SECRET";

    public void testMethods() throws Exception {
        String expected = "Hello";

        String encoded = AES256.encrypt(expected, KEY);
        
        //System.out.println("ENCODED: "+encoded);

        String decoded = AES256.decrypt(encoded, KEY);

        //System.out.println("DECODED: "+decoded);

        assertEquals(decoded, expected);
    }

}