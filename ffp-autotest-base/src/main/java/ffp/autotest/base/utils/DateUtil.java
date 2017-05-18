/**
 * Aaron.ffp Inc.
 * Copyright (c) 2017-2100 All Rights Reserved.
 */
package ffp.autotest.base.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import ffp.autotest.base.variables.DateFormatVariable;

/**
 * <strong>日期时间工具类</strong><br>
 * 
 * @author FanFengping
 * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils DateUtil.java, 2017-04-30 22:19:22 Exp $
 */
public class DateUtil {
    public DateUtil() {
    }
    
    /**
     * <strong>获取当前日期（样式：HHmmss）</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils DateUtil.java getHMS Exp $
     * 
     * @return 格式化日期
     */
    public static String getHMS() {
        return getDateTime(DateFormatVariable.SDF_HMS);
    }
    
    /**
     * <strong>获取当前日期（样式：HH:mm:ss）</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils DateUtil.java getHHMMSS Exp $
     * 
     * @return 格式化日期
     */
    public static String getHHMMSS(){
        return getDateTime(DateFormatVariable.SDF_HHMMSS);
    }
    
    /**
     * <strong>获取当前日期（样式：yyyyMMdd）</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils DateUtil.java getYMD Exp $
     * 
     * @return 格式化日期
     */
    public static String getYMD() {
        return getDateTime(DateFormatVariable.SDF_YMD);
    }
    
    /**
     * <strong>获取当前日期（样式：yyyy-MM-dd）</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils DateUtil.java getYYYYMMDD Exp $
     * 
     * @return 格式化日期
     */
    public static String getYYYYMMDD() {
        return getDateTime(DateFormatVariable.SDF_YYYYMMDD);
    }
    
    /**
     * <strong>获取当前日期（样式：yyyy-MM-dd HH:mm:ss.SSS）</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils DateUtil.java getDefault Exp $
     * 
     * @return 格式化日期
     */
    public static String getDefault(){
        return getDateTime(DateFormatVariable.SDF_DEFAULT);
    }
    
    /**
     * <strong>获取当前系统日期（指定格式）</strong><br>
     * <ul>
     * <li>若日期格式化样式为空，则默认返回样式（yyyy-MM-dd HH:mm:ss.SSS）</li>
     * </ul>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils DateUtil.java getDateTime Exp $
     * 
     * @param simpleDateFormat 日期格式化样式
     * @return 格式化日期
     */
    public static String getDateTime(String simpleDateFormat) {
        simpleDateFormat = StringUtil.empty(simpleDateFormat, DateFormatVariable.SDF_DEFAULT);
        
        return new SimpleDateFormat(simpleDateFormat).format(new Date());
    }


}
