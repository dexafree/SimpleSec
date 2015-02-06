package com.dexafree.simplesec;

public class SHA512 {

    public static String hash(String text) {

        return HashCommons.hash(text, "SHA-512");

    }

}
