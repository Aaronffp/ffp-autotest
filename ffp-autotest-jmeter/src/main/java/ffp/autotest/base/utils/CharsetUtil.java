/**
 * Aaron.ffp Inc.
 * Copyright (c) 范丰平（263869564@qq.com） 2017-2100 All Rights Reserved.
 */
package ffp.autotest.base.utils;

import java.nio.charset.Charset;

import ffp.autotest.base.variables.CharsetVariable;

/**
 * <strong>字符编码工具类</strong><br><br>
 * <br>
 * @author FanFengping
 * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils CharsetUtil.java, 2017-04-30 11:03:32 Exp $
 */
public class CharsetUtil {
    public CharsetUtil() {
    }
    
    /**
     * <strong>设置编码为UTF-8，若编码为空</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils CharsetUtil.java Exp $
     * 
     * @param charset 编码
     * @return 编码
     */
    public static String setDefault(String charset) {
        return StringUtil.isEmpty(charset) ? CharsetVariable.CHARSET_UTF8 : charset;
    }
    
    /**
     * <strong>获取默认编码</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils CharsetUtil.java Exp $
     * 
     * @return 默认编码
     */
    public static String getDefault() {
        return Charset.defaultCharset().name();
    }
    
    /**
     * <strong>验证编码是否合法</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils CharsetUtil.java Exp $
     * 
     * @param charset 编码
     * @return 当编码为空或不支持编码时，返回为false
     */
    public static boolean valid(String charset) {
        return StringUtil.isEmpty(charset) ? false : Charset.isSupported(charset);
    }
}
