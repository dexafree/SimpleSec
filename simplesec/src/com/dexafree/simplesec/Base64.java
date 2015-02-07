package com.dexafree.simplesec;


import java.nio.charset.StandardCharsets;

public class Base64 {

    public static String encode(String text){
        return encode(text.getBytes(StandardCharsets.UTF_8));
    }

    public static String decode(String text){
        return decode(text.getBytes(StandardCharsets.UTF_8));
    }
    
    static String encode(byte[] text){
        return net.iharder.Base64.encodeBytes(text);
    }
    
    static byte[] encodeBytes(byte[] bytes){
        return net.iharder.Base64.encodeBytesToBytes(bytes);
    }

    static String decode(byte[] text){
        try {
            return new String(net.iharder.Base64.decode(text), StandardCharsets.UTF_8);
        } catch (Exception e){
            e.printStackTrace();
        }
        
        return "BASE64 DECODING FAILED";
    }
    
    static byte[] decodeBytes(String text){
        return decodeBytes(text.getBytes(StandardCharsets.UTF_8));
    }
    
    static byte[] decodeBytes(byte[] text){
        try{
            return net.iharder.Base64.decode(text);
        } catch (Exception e){
            e.printStackTrace();
        }
        return "BASE64 DECODING FAILED".getBytes();
    }

}