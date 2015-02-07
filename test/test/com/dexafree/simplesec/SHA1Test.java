package com.dexafree.simplesec;

import junit.framework.TestCase;

public class SHA1Test extends TestCase {

    public void testHash() {
        String hello = "Hello";
        String expectedHash = "f7ff9e8b7bb2e09b70935a5d785e0cc5d9d0abf0";

        String hash = SHA1.hash(hello);

        assertEquals(expectedHash, hash);
    }
}