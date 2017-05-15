/**
 * Aaron.ffp Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package ffp.autotest.base.utils;

import java.nio.charset.Charset;

import ffp.autotest.base.variables.CharsetVariable;

/**
 * <strong>字符编码工具类</strong><br><br>
 * <br>
 * @author FanFengping
 * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils CharsetUtil.java, 2017年5月4日 下午11:57:10 Exp $
 */
public class CharsetUtil {

    public CharsetUtil() {
    }
    
    public static String setDefault(String charset) {
        return StringUtil.isEmpty(charset) ? CharsetVariable.CHARSET_UTF8 : charset;
    }
    
    public static String getDefault() {
        return Charset.defaultCharset().name();
    }
    
    public static boolean valid(String charset) {
        return StringUtil.isEmpty(charset) ? false : Charset.isSupported(charset);
    }
}
