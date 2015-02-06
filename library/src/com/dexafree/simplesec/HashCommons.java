package com.dexafree.simplesec;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class HashCommons {

    static String convertToHex(byte[] data) {
        StringBuilder buf = new StringBuilder();
        for (byte b : data) {
            int halfbyte = (b >>> 4) & 0x0F;
            int two_halfs = 0;
            do {
                buf.append((0 <= halfbyte) && (halfbyte <= 9) ? (char) ('0' + halfbyte) : (char) ('a' + (halfbyte - 10)));
                halfbyte = b & 0x0F;
            } while (two_halfs++ < 1);
        }
        return buf.toString();
    }

    static String hash(String text, String algorithm){
        String hash = "FAIL";

        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            md.update(text.getBytes("UTF-8"), 0, text.length());
            byte[] sha1hash = md.digest();
            hash = HashCommons.convertToHex(sha1hash);
        } catch (NoSuchAlgorithmException e){
            //Log.e(TAG, "No such algorithm");
            e.printStackTrace();
        } catch (UnsupportedEncodingException e){
            //Log.e(TAG, "Unsupported encoding");
            e.printStackTrace();
        }

        return hash;
    }

}
