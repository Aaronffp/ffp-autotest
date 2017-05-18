/**
 * Aaron.ffp Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package ffp.autotest.base.utils;

import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.math.IntMath;

/**
 * <strong>字符工具类</strong><br><br>
 * <br>
 * @author FanFengping
 * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils StringUtil.java, 2017-04-29 20:30:43 Exp $
 */
public class StringUtil {

    public StringUtil() {
    }
    
    /**
     * <strong>字符串分隔</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils StringUtil.java, 2017-04-29 20:57:18 Exp $
     * 
     * @param string 字符串
     * @param separator 分隔符
     * @return
     */
    public static List<String> split(String string, String separator) {
        return Splitter.on(empty(separator, "")).trimResults().splitToList(string);
    }
    
    /**
     * <strong>字符串分隔</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils StringUtil.java, 2017-04-29 20:55:18 Exp $
     * 
     * @param string 字符串
     * @param pattern 分隔符（支持正则）
     * @return
     */
    public static List<String> splitPattern(String string, String pattern) {
        return Splitter.onPattern(empty(pattern, "")).trimResults().splitToList(empty(string, ""));
    }
    
    /**
     * <strong>首位补齐字符串</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils StringUtil.java, 2017-04-29 20:52:48 Exp $
     * 
     * @param string 原始字符串
     * @param minLength 补齐后最小长度
     * @param repeat 填充字符串
     * @return
     */
    public static String padStart(String string, int minLength, String repeat) {
        repeat = empty(repeat, "");
        string = empty(string, "");
        
        if (repeat.length() == 0) {
            return string;
        }
        
        int count = IntMath.divide((minLength - repeat.length()) , repeat.length(), RoundingMode.HALF_UP);
        
        return repeat(repeat, count) + string;
    }
    
    /**
     * <strong>末尾补齐字符串</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils StringUtil.java, 2017-04-29 20:47:38 Exp $
     * 
     * @param string 原始字符串
     * @param minLength 补齐后最小长度
     * @param repeat 填充字符串
     * @return
     */
    public static String padEnd(String string, int minLength, String repeat) {
        repeat = empty(repeat, "");
        string = empty(string, "");
        
        if (repeat.length() == 0) {
            return string;
        }
        
        int count = IntMath.divide((minLength - repeat.length()) , repeat.length(), RoundingMode.HALF_UP);
        
        return string + repeat(repeat, count);
    }
    
    /**
     * <strong>重复输出字符串</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils StringUtil.java, 2017-04-29 20:46:38 Exp $
     * 
     * @param string 字符串
     * @param count 重复次数
     * @return 当字符串为空时，返回空字符串。
     */
    public static String repeat(String string, int count) {
        return Strings.repeat(empty(string, ""), count);
    }
    
    /**
     * <strong>小写字符串</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils StringUtil.java, 2017-04-29 20:43:38 Exp $
     * 
     * @param string 字符串
     * @return 当字符串为空时，返回空字符串。
     */
    public static String lower(String string) {
        return isEmpty(string) ? "" : string.toLowerCase();
    }
    
    /**
     * <strong>大写字符串</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils StringUtil.java, 2017-04-29 20:43:23 Exp $
     * 
     * @param string 字符串
     * @return 当字符串为空时，返回空字符串。
     */
    public static String upper(String string) {
        return isEmpty(string) ? "" : string.toUpperCase();
    }
    
    /**
     * <strong>若字符串为空，设置默认值</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils StringUtil.java, 2017-04-29 20:36:23 Exp $
     * 
     * @param string 字符串
     * @param defaultValue 默认值
     * @return
     */
    public static String empty(String string, String defaultValue) {
        return isEmpty(string) ? defaultValue : string; 
    }
    
    /**
     * <strong>验证字符串是否为空</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils StringUtil.java, 2017-04-29 20:35:43 Exp $
     * 
     * @param string 字符串
     * @return
     */
    public static boolean isEmpty(String string) {
        return Objects.equals(string, "") || Objects.isNull(string) || (string.length() == 0);
    }
    
    /**
     * <strong>验证字符串是否为null</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils StringUtil.java, 2017-04-29 20:33:56 Exp $
     * 
     * @param string 字符串
     * @return
     */
    public static boolean isNull(String string) {
        return string == null;
    }
    
    /**
     * <strong>验证字符串是否由纯数字组成</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils StringUtil.java, 2017-04-29 20:33:32 Exp $
     * 
     * @param string 字符串
     * @return
     */
    public static boolean isNumeric(String string) {
        if (isEmpty(string))
            return false;

        int l = string.length();
        for (int i = 0; i < l; i++) {
            if (!Character.isDigit(string.codePointAt(i)))
                return false;
        }
        return true;
    }
}
