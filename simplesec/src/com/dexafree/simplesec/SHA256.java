package com.dexafree.simplesec;


public class SHA256 {

    private final static String TAG = "SIMPLESEC-SHA256";

    public static String hash(String text) {

        return HashCommons.hash(text, "SHA-256");

    }

}
