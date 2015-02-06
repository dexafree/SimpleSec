package com.dexafree.simplesec;

import junit.framework.TestCase;

public class SHA256Test extends TestCase{

    public void testHash() {
        String hello = "Hello";
        String expectedHash = "185f8db32271fe25f561a6fc938b2e264306ec304eda518007d1764826381969";

        String hash = SHA256.hash(hello);

        assertEquals(expectedHash, hash);
    }
}