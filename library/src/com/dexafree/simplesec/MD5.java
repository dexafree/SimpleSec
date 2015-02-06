package com.dexafree.simplesec;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {

    public static String hash(String text) {

        return HashCommons.hash(text, "MD5");

    }

}
