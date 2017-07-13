/**
 * Aaron.ffp Inc.
 * Copyright (c) 范丰平（263869564@qq.com） 2017-2100 All Rights Reserved.
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

/**
 * <strong>AES加解密</strong><br><br>
 * <br>
 * @author FanFengping
 * @version V1.0.0: ffp-autotest-base ffp.autotest.base.crypt AESCrypt.java, 2017-04-30 12:09:22 Exp $
 */
public class AESCrypt {
    private String key = "";
    private String charset = "UTF-8";
    
    public AESCrypt(String key, String charset) {
        this.key = key;
        this.charset = charset;
    }
    
    public String encrypt(String string) {
        return encrypt(this.key, string, this.charset);
    }
    
    public String decrypt(String string) {
        return decrypt(this.key, string, this.charset);
    }

    /**
     * <strong>AES加密</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.crypt AESCrypt.java encrypt Exp $
     * 
     * @param encryptKey 密钥
     * @param string 加密字符串
     * @param charset 字符串编码
     * @return 加密后字符串
     */
    private static String encrypt(String key, String string, String charset) {
        try {
            // 1.构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            // 2.根据ecnodeRules规则初始化密钥生成器，生成一个128位的随机源，根据传入的字节数组
            keygen.init(128, new SecureRandom(key.getBytes(charset)));
            // 3.产生原始对称密钥
            SecretKey original_key = keygen.generateKey();
            // 4.获得原始对称密钥的字节数组
            byte[] raw = original_key.getEncoded();
            // 5.根据字节数组生成AES密钥
            SecretKey secretKey = new SecretKeySpec(raw, "AES");
            // 6.根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance("AES");
            // 7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            // 8.获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
            byte[] byte_encode = string.getBytes(charset);
            // 9.根据密码器的初始化方式--加密：将数据加密
            byte[] byte_AES = cipher.doFinal(byte_encode);
            // 10.解决 BASE64Encoder 编译时会警告信息：sun.misc.BASE64Encoder是内部专用 API, 可能会在未来发行版中删除
            // 采用 Apache 专门的 http://commons.apache.org/proper/commons-codec/ 来做 encode
            String AES_encode = Base64.encodeBase64String(byte_AES);
            // 11.将字符串返回
            return AES_encode;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException
                | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * <strong>AES解密</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.crypt AESCrypt.java decrypt Exp $
     * 
     * @param decryptKey 解密密钥
     * @param string 解密字符串
     * @param charset 字符串编码
     * @return 解密后字符串
     */
    private static String decrypt(String decryptKey, String string, String charset) {
        try {
            // 1.构造密钥生成器，指定为AES算法,不区分大小写
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            // 2.根据ecnodeRules规则初始化密钥生成器，生成一个128位的随机源，根据传入的字节数组
            keygen.init(128, new SecureRandom(decryptKey.getBytes(charset)));
            // 3.产生原始对称密钥
            SecretKey original_key = keygen.generateKey();
            // 4.获得原始对称密钥的字节数组
            byte[] raw = original_key.getEncoded();
            // 5.根据字节数组生成AES密钥
            SecretKey secretKey = new SecretKeySpec(raw, "AES");
            // 6.根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance("AES");
            // 7.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            // 8.将加密并编码后的内容解码成字节数组
            // byte [] byte_content= new BASE64Decoder().decodeBuffer(content);

            byte[] byte_content = Base64.decodeBase64(string);
            // 解密
            byte[] byte_decode = cipher.doFinal(byte_content);
            String AES_decode = new String(byte_decode, charset);
            return AES_decode;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException
                | IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    

    /**
     * Getter method for property <tt>key</tt>.
     * 
     * @return property value of key
     */
    public String getKey() {
        return key;
    }

    /**
     * Setter method for property <tt>key</tt>.
     * 
     * @param key value to be assigned to property key
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Getter method for property <tt>charset</tt>.
     * 
     * @return property value of charset
     */
    public String getCharset() {
        return charset;
    }

    /**
     * Setter method for property <tt>charset</tt>.
     * 
     * @param charset value to be assigned to property charset
     */
    public void setCharset(String charset) {
        this.charset = charset;
    }
}
