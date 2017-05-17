/**
 * Aaron.ffp Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package ffp.autotest.base.utils;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

/**
 * <strong>Apache BASE64工具类</strong><br><br>
 * <ul>
 * <li>用于替换sun.misc.BASE64Encoder的内部类警告问题</li>
 * </ul>
 * <br>
 * @author FanFengping
 * @version V1.0.0: ffp-autotest-base ffp.autotest.base.crypt BASE64Crypt.java, 2017年5月4日 下午11:18:20 Exp $
 */
public class Base64Util {
    public Base64Util() {
    }
    
    public static String encode(String string, String charset) throws UnsupportedEncodingException {
        return Base64.encodeBase64String(StringUtil.empty(string, "").getBytes(CharsetUtil.setDefault(charset)));
    }
    
    public static String decode(String string, String charset) throws UnsupportedEncodingException {
        return new String(Base64.decodeBase64(StringUtil.empty(string, "")), CharsetUtil.setDefault(charset));
    }

}
