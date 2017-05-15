/**
 * Aaron.ffp Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package ffp.autotest.base.crypt;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class AESCrypt {
    public AESCrypt() {
    }

    public static String encrypt(String encryptKey, String content, String charset) {
        try {
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            keygen.init(128, new SecureRandom(encryptKey.getBytes(charset)));
            SecretKey original_key = keygen.generateKey();
            byte[] raw = original_key.getEncoded();
            SecretKey key = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] byte_encode = content.getBytes(charset);
            byte[] byte_AES = cipher.doFinal(byte_encode);
            String AES_encode = Base64.encodeBase64String(byte_AES);
            return AES_encode;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String decrypt(String encryptKey, String content, String charset) {
        try {
            KeyGenerator keygen=KeyGenerator.getInstance("AES");
            keygen.init(128, new SecureRandom(encryptKey.getBytes(charset)));
            SecretKey original_key=keygen.generateKey();
            byte [] raw=original_key.getEncoded();
            SecretKey key=new SecretKeySpec(raw, "AES");
            Cipher cipher=Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte [] byte_content= Base64.decodeBase64(content);
            byte [] byte_decode=cipher.doFinal(byte_content);
            String AES_decode=new String(byte_decode, charset);
            return AES_decode;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
