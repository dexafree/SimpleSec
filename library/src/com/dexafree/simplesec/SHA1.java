package com.dexafree.simplesec;

public class SHA1 {

    private final static String TAG = "SIMPLESEC-SHA1";

    public static String hash(String text) {

        return HashCommons.hash(text, "SHA-1");
        
    }
}
