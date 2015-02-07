package com.dexafree.simplesec;


import java.nio.charset.StandardCharsets;

public class Base64 {

    private final static org.apache.commons.codec.binary.Base64 mBase = new org.apache.commons.codec.binary.Base64();

    public static String encode(String text){
        return new String(mBase.encode(text.getBytes()), StandardCharsets.UTF_8);
    }

    public static String decode(String text){
        return new String(mBase.decode(text), StandardCharsets.UTF_8);
    }

}