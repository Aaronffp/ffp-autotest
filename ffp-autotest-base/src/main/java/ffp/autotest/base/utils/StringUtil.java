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
 * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils StringUtil.java, 2017年5月4日 下午11:25:44 Exp $
 */
public class StringUtil {

    public StringUtil() {
    }
    
    public static List<String> split(String string, String separator) {
        return Splitter.on(empty(string, "")).trimResults().splitToList(string);
    }
    
    public static List<String> splitPattern(String string, String pattern) {
        return Splitter.onPattern(empty(pattern, "")).trimResults().splitToList(empty(string, ""));
    }
    
    public static String padStart(String string, int minLength, String repeat) {
        repeat = empty(repeat, "");
        
        if (repeat.length() == 0) {
            return empty(string, "");
        }
        
        int count = IntMath.divide((minLength - repeat.length()) , repeat.length(), RoundingMode.HALF_UP);
        
        return isEmpty(string) + repeat(repeat, count);
    }
    
    public static String padEnd(String string, int minLength, String repeat) {
        repeat = empty(repeat, "");
        string = empty(string, "");
        
        if (repeat.length() == 0) {
            return string;
        }
        
        int count = IntMath.divide((minLength - repeat.length()) , repeat.length(), RoundingMode.HALF_UP);
        
        return repeat(repeat, count) + string;
    }
    
    public static String repeat(String string, int count) {
        return Strings.repeat(empty(string, ""), count);
    }
    
    public static String lower(String string) {
        return isEmpty(string) ? "" : string.toLowerCase();
    }
    
    public static String upper(String string) {
        return isEmpty(string) ? "" : string.toUpperCase();
    }
    
    public static String empty(String string, String defaultValue) {
        return isEmpty(string) ? defaultValue : string; 
    }
    
    public static boolean isEmpty(String string) {
        return Objects.equals(string, "") || Objects.isNull(string) || (string.length() == 0);
    }
    
    public static boolean isNull(String string) {
        return string == null;
    }
    
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
