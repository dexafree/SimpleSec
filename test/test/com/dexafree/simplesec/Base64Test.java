package com.dexafree.simplesec;

import junit.framework.TestCase;

public class Base64Test extends TestCase {

    public void testEncode(){
        String hello = "Hello";
        String expected = "SGVsbG8=";

        String encoded = Base64.encode(hello);

        assertEquals(expected, encoded);
    }

    public void testDecode(){
        String encoded = "SGVsbG8=";
        String expected = "Hello";

        String decoded = Base64.decode(encoded);

        assertEquals(expected, decoded);
    }

}