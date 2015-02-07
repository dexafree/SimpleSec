package com.dexafree.simplesec.tests;

import com.dexafree.simplesec.AES;
import junit.framework.TestCase;

public class AESTest extends TestCase {

    private final static String KEY = "MY_SUPER_SECRET_AND_LONG_KEY_THAT_YOU_WOULD_NEVER_GUESS";

    public void testMethods() throws Exception {
        String expected = "Hello";

        String encoded = AES.encrypt(expected, KEY);
        
        //System.out.println("ENCODED: "+encoded);

        String decoded = AES.decrypt(encoded, KEY);

        //System.out.println("DECODED: "+decoded);

        assertEquals(decoded, expected);
    }

}