package com.dexafree.simplesec.tests;

import com.dexafree.simplesec.MD5;
import junit.framework.TestCase;

public class MD5Test extends TestCase {

    public void testHash() {

        String hello = "Hello";
        String expectedHash = "8b1a9953c4611296a827abf8c47804d7";

        String hash = MD5.hash(hello);

        assertEquals(expectedHash, hash);
    }
}