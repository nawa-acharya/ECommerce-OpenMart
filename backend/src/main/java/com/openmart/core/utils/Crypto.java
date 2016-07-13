package com.openmart.core.utils;

import org.springframework.security.crypto.codec.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.MessageDigest;

import static sun.security.x509.CertificateAlgorithmId.ALGORITHM;

/**
 * Created by Nawa on 7/13/2016.
 */
public class Crypto {
    public Crypto() {

    }
    private static final String ALGO = "AES";
    private static final byte[] keyValue = "ADBSJHJS12547896".getBytes();

    public static String encrypt(String valueToEnc) throws Exception {

        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);

        System.out.println("valueToEnc.getBytes().length "+valueToEnc.getBytes().length);
        byte[] encValue = c.doFinal(valueToEnc.getBytes());
        System.out.println("encValue length" + encValue.length);
        byte[] encryptedByteValue = new Base64().encode(encValue);
        String encryptedValue = encryptedByteValue.toString();
        System.out.println("encryptedValue " + encryptedValue);
        return encryptedValue;
    }
    private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
    }
}

