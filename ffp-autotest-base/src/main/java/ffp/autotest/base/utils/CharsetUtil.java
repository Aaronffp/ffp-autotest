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
 * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils CharsetUtil.java, 2017-04-30 11:03:32 Exp $
 */
public class CharsetUtil {

    public CharsetUtil() {
    }
    
    /**
     * <strong>设置编码为UTF-8，若编码为空</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils CharsetUtil.java, 2017-04-30 11:04:12 Exp $
     * 
     * @param charset 编码
     * @return
     */
    public static String setDefault(String charset) {
        return StringUtil.isEmpty(charset) ? CharsetVariable.CHARSET_UTF8 : charset;
    }
    
    /**
     * <strong>获取默认编码</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils CharsetUtil.java, 2017-04-30 11:01:43 Exp $
     * 
     * @return
     */
    public static String getDefault() {
        return Charset.defaultCharset().name();
    }
    
    /**
     * <strong>验证编码是否合法</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils CharsetUtil.java, 2017-04-30 11:01:04 Exp $
     * 
     * @param charset 编码
     * @return
     */
    public static boolean valid(String charset) {
        return StringUtil.isEmpty(charset) ? false : Charset.isSupported(charset);
    }
}
