package com.dexafree.simplesec.tests;

import com.dexafree.simplesec.TripleDES;
import junit.framework.TestCase;

public class TripleDESTest extends TestCase {

    private final static String KEY = "MY_SUPER_SECRET_AND_LONG_KEY_THAT_YOU_WOULD_NEVER_GUESS";

    public void testMethods() {
        String expected = "Hello";

        String encoded = TripleDES.encrypt(expected, KEY);

        String decoded = TripleDES.decrypt(encoded, KEY);

        assertEquals(decoded, expected);
    }

}