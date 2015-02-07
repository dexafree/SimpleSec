package com.dexafree.simplesec;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class TripleDES{

    private final static Base64 mBase = new Base64();

    public static String encrypt(String message, String key) {

        try {
            final MessageDigest md = MessageDigest.getInstance("md5");
            final byte[] digestOfPassword = md.digest(key.getBytes(StandardCharsets.UTF_8));
            final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            for (int j = 0, k = 16; j < 8; ) {
                keyBytes[k++] = keyBytes[j++];
            }

            final SecretKey keySecret = new SecretKeySpec(keyBytes, "DESede");
            final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
            final Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, keySecret, iv);

            final byte[] plainTextBytes = message.getBytes("utf-8");
            final byte[] cipherText = cipher.doFinal(plainTextBytes);
            // final String encodedCipherText = new sun.misc.BASE64Encoder()
            // .encode(cipherText);

            return new String(mBase.encode(cipherText));
        } catch (Exception e){
            e.printStackTrace();
        }

        return "FAIL";
    }

    public static String decrypt(String message, String key) {

        try {
            byte[] realMessage = mBase.decode(message.getBytes());

            final MessageDigest md = MessageDigest.getInstance("md5");
            final byte[] digestOfPassword = md.digest(key.getBytes("utf-8"));
            final byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            for (int j = 0, k = 16; j < 8; ) {
                keyBytes[k++] = keyBytes[j++];
            }

            final SecretKey keySecret = new SecretKeySpec(keyBytes, "DESede");
            final IvParameterSpec iv = new IvParameterSpec(new byte[8]);
            final Cipher decipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
            decipher.init(Cipher.DECRYPT_MODE, keySecret, iv);

            // final byte[] encData = new
            // sun.misc.BASE64Decoder().decodeBuffer(message);
            final byte[] plainText = decipher.doFinal(realMessage);

            return new String(plainText, StandardCharsets.UTF_8);
        } catch (Exception e){
            e.printStackTrace();
        }

        return "FAIL";
    }
}
