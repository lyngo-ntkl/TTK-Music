/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lyntk.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Dell
 */
public class EncryptionUtil {
    private static final String ALGORITHM = "MD5";
    
    public static String encrypt(String password) throws NoSuchAlgorithmException{
        String result = "";
        try {
            byte[] bytesBuffer = password.getBytes();
            MessageDigest digest = MessageDigest.getInstance(ALGORITHM);
            digest.update(bytesBuffer);
            byte[] hashedBytes = digest.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < hashedBytes.length; ++i) {
                sb.append(Integer.toHexString((hashedBytes[i] & 0xFF) | 0x100).substring(1, 3));
            }
            result = sb.toString();
        } catch (Exception e) {
            throw e;
        }
        return result;
    }
}
