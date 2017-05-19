/**
 * Aaron.ffp Inc.
 * Copyright (c) 2017-2100 All Rights Reserved.
 */
package ffp.autotest.base.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import com.google.common.base.Objects;

import ffp.autotest.base.variables.GlobalVariable;

/**
 * <strong>Properties工具类</strong><br>
 * 
 * @author FanFengping
 * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils PropertiesUtil.java Exp $
 */
public class PropertiesUtil {
    private static Properties props = null;

    public PropertiesUtil() {
    }
    
    public PropertiesUtil(String... propertiesPath) {
        props = loadProperties(propertiesPath);
    }
    
    /**
     * <strong>获取Boolean类型的Property，以System.Property优先</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils PropertiesUtil.java getBoolean Exp $
     * 
     * @param key 键
     * @param defaultProperty 默认值
     * @return 若配置项不为true/false（不区分大小写）时，返回默认值
     */
    public static Boolean getBoolean(String key, Boolean defaultProperty) {
        String value = getProperty(key).toLowerCase();
        return StringUtil.isEmpty(value) || Objects.equal("false", value) || Objects.equal("true", value) ? defaultProperty : Boolean.valueOf(value);
    }
    
    /**
     * <strong>获取Boolean类型的Property，以System.Property优先</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils PropertiesUtil.java getBoolean Exp $
     * 
     * @param key 键
     * @return 当且仅当配置项为true（不区分大小写）时，返回true
     */
    public static Boolean getBoolean(String key) {
        return Boolean.valueOf(getProperty(key));
    }
    
    /**
     * <strong>获取Double类型的Property，以System.Property优先</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils PropertiesUtil.java getDouble Exp $
     * 
     * @param key 键
     * @param defaultProperty 默认值
     * @return 当配置项不为浮点数时，返回默认值
     */
    public static Double getDouble(String key, Double defaultProperty) {
        try {
            return Double.valueOf(getProperty(key));
        } catch (Exception e) {
            return defaultProperty;
        }
    }
    
    /**
     * <strong>获取Double类型的Property，以System.Property优先</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils PropertiesUtil.java getDouble Exp $
     * 
     * @param key 键
     * @return 当配置项不为浮点数时，抛出 NumberFormatException 异常
     */
    public static Double getDouble(String key) {
        return Double.valueOf(getProperty(key));
    }
    
    /**
     * <strong>获取Integer类型的Property，以System.Property优先</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils PropertiesUtil.java getInteger Exp $
     * 
     * @param key 键
     * @param defaultProperty 默认值
     * @return 当配置项不为整数时，返回默认值
     */
    public static Integer getInteger(String key, Integer defaultProperty) {
        String value = getProperty(key);
        return StringUtil.isNumeric(value) ? Integer.valueOf(value) : defaultProperty;
    }
    
    /**
     * <strong>获取Integer类型的Property，以System.Property优先</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils PropertiesUtil.java getInteger Exp $
     * 
     * @param key 键
     * @return 当配置项不为整数时，抛出 NumberFormatException 异常
     */
    public static Integer getInteger(String key) {
        return Integer.valueOf(getProperty(key));
    }
    
    /**
     * <strong>获取String类型的Property，以System.Property优先</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils PropertiesUtil.java getProperty Exp $
     * 
     * @param key 键
     * @param defaultProperty 默认值
     * @return 当配置项不存在时，返回默认值
     */
    public static String getProperty(String key, String defaultProperty) {
        return getProperty(key) == null ? defaultProperty : getProperty(key);
    }
    
    /**
     * <strong>获取String类型的Property，以System.Property优先</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils PropertiesUtil.java getProperty Exp $
     * 
     * @param key 键
     * @return 当配置项不存在时，返回null
     */
    public static String getProperty(String key){
        String systemProperty = GlobalVariable.getProperty(key);
        String configProperty = props.containsKey(key) ? props.getProperty(key) : null;
        
        return systemProperty == null ? configProperty : systemProperty;
    }
    
    /**
     * <strong>获取资源配置</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils PropertiesUtil.java loadProperties Exp $
     * 
     * @param propertiesPaths 资源配置文件
     * @return Properties
     */
    private static Properties loadProperties(String... propertiesPaths) {
        Properties properties = new Properties();

        for (String propertie : propertiesPaths) {
            InputStream inputStream = null;
            try {
                inputStream = new BufferedInputStream(new FileInputStream(propertie));
                properties.load(inputStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                IOUtils.closeQuietly(inputStream);
            }
        }
        
        return properties;
    }

    /**
     * Getter method for property <tt>props</tt>.
     * 
     * @return property value of props
     */
    public static Properties getProps() {
        return props;
    }

    /**
     * Setter method for property <tt>props</tt>.
     * 
     * @param props value to be assigned to property props
     */
    public static void setProps(Properties props) {
        PropertiesUtil.props = props;
    }
}
