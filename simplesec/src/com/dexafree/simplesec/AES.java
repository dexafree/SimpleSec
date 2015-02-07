package com.dexafree.simplesec;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AES {

    private static final String ALGORITHM = "AES";

    private static String padKey(String key){

        if(key.length() > 32)
            return key.substring(0, 32);

        String tempKey = key;

        while(tempKey.length() % 16 != 0){
            tempKey += "A";
        }

        return tempKey;
    }

    public static String encrypt(String valueToEnc, String key){

        try {
            byte[] keyValue = padKey(key).getBytes();

            Key generatedKey = generateKey(keyValue);
            Cipher c = Cipher.getInstance(ALGORITHM);
            c.init(Cipher.ENCRYPT_MODE, generatedKey);

            byte[] encValue = c.doFinal(valueToEnc.getBytes());
            byte[] encryptedByteValue = Base64.encodeBytes(encValue);
            String encryptedValue = new String(encryptedByteValue);

            return encryptedValue;
        } catch (Exception e){
            e.printStackTrace();
        }

        return "FAIL";

    }

    public static String decrypt(String encryptedValue, String key) {

        try {
            byte[] keyValue = padKey(key).getBytes();

            Key generatedKey = generateKey(keyValue);
            Cipher c = Cipher.getInstance(ALGORITHM);
            c.init(Cipher.DECRYPT_MODE, generatedKey);

            byte[] decodedValue = Base64.decodeBytes(encryptedValue.getBytes());
            byte[] decryptedVal = c.doFinal(decodedValue);
            return new String(decryptedVal);
        } catch (Exception e){
            e.printStackTrace();
        }

        return "FAIL";
    }

    private static Key generateKey(byte[] keyValue) throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGORITHM);
        return key;
    }

}