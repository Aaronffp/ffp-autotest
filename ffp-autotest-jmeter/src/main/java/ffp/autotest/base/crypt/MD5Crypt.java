/**
 * Aaron.ffp Inc.
 * Copyright (c) 范丰平（263869564@qq.com） 2017-2100 All Rights Reserved.
 */
package ffp.autotest.base.crypt;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import ffp.autotest.base.utils.CharsetUtil;
import ffp.autotest.base.utils.StringUtil;

/**
 * <strong>MD5工具类</strong><br><br>
 * <br>
 * @author FanFengping
 * @version V1.0.0: ffp-autotest-base ffp.autotest.base.crypt MD5Crypt.java, 2016-04-30 20:34:12 Exp $
 */
public class MD5Crypt {
    private String charset = "UTF-8";

    public MD5Crypt(String charset) {
        this.charset = charset;
    }
    
    public String encrypt16(String string){
        return encrypt16(string, this.charset);
    }
    
    public String encrypt(String string) {
        return encrypt(string, this.charset);
    }
    
    /**
     * <strong>MD5加密（16位）</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.crypt MD5Crypt.java encrypt16 Exp $
     * 
     * @param string 加密字符串
     * @param charset 字符串编码
     * @return 加密后字符串
     */
    private static String encrypt16(String string, String charset) {
        return encrypt(string, charset).substring(8, 24);
    }
    
    /**
     * <strong>MD5加密（32位）</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.crypt MD5Crypt.java encrypt Exp $
     * 
     * @param string 加密字符串
     * @param charset 字符串编码
     * @return 加密后字符串
     */
    private static String encrypt(String string, String charset) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
            
            string = StringUtil.empty(string, "");
            charset = CharsetUtil.setDefault(charset);
            
            md5.update(string.getBytes(charset));
            
            byte b[] = md5.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            
            return buf.toString();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
