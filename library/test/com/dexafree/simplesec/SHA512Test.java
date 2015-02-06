package com.dexafree.simplesec;

import junit.framework.TestCase;

public class SHA512Test extends TestCase {

    public void testHash() {
        String hello = "Hello";
        String expectedHash = "3615f80c9d293ed7402687f94b22d58e529b8cc7916f8fac7fddf7fbd5af4cf777d3d795a7a00a16bf7e7f3fb9561ee9baae480da9fe7a18769e71886b03f315";

        String hash = SHA512.hash(hello);

        assertEquals(expectedHash, hash);
    }
}