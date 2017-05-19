/**
 * Aaron.ffp Inc.
 * Copyright (c) 2017-2100 All Rights Reserved.
 */
package ffp.autotest.base.variables;

import java.util.Properties;

/**
 * <strong>系统变量类</strong><br>
 * 
 * @author FanFengping
 * @version V1.0.0: ffp-autotest-base ffp.autotest.base.variables GlobalVariable.java, 2017-04-30 22:09:22 Exp $
 */
public class GlobalVariable {
    private static final Properties sysProperties     = System.getProperties();

    public static final String     USER_NAME         = sysProperties.getProperty("user.name");         // Aaron
    public static final String     USER_HOME         = sysProperties.getProperty("user.home");         // C:\Users\Aaron
    public static final String     USER_LANGUAGE     = sysProperties.getProperty("user.language");     // zh
    public static final String     USER_COUNTRY      = sysProperties.getProperty("user.country");      // CN
    public static final String     USER_TIMEZONE     = sysProperties.getProperty("user.timezone");     // Asia/Shanghai

    public static final String     PROJECT_HOME      = sysProperties.getProperty("user.dir");

    public static final String     JAVA_VERSION      = sysProperties.getProperty("java.version");      // 1.8.0
    public static final String     JAVA_HOME         = sysProperties.getProperty("java.home");         // C:\Java\jdk8\jre
    public static final String     JAVA_RUNTIME_NAME = sysProperties.getProperty("java.runtime.name"); // Java(TM) SE Runtime Environment
    public static final String     JAVA_VM_NAME      = sysProperties.getProperty("java.vm.name");      // Java HotSpot(TM) 64-Bit Server VM
    public static final String     JAVA_VM_VENDOR    = sysProperties.getProperty("java.vm.vendor");    // Oracle Corporation

    public static final String     OS_NAME           = sysProperties.getProperty("os.name");           // Windows 7
    public static final String     OS_ARCH           = sysProperties.getProperty("os.arch");           // amd64
    public static final String     OS_VERSION        = sysProperties.getProperty("os.version");        // 6.1

    public static final String     OS_FILE_SEPARATOR = sysProperties.getProperty("file.separator");
    public static final String     OS_PATH_SEPARATOR = sysProperties.getProperty("path.separator");
    public static final String     OS_LINE_SEPARATOR = sysProperties.getProperty("line.separator");
    
    /**
     * <strong>获取系统配置</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.variables GlobalVariable.java getProperty Exp $
     * 
     * @param key 键
     * @return 当系统配置不存在时，返回null
     */
    public static String getProperty(String key) {
        return sysProperties.containsKey(key) ? sysProperties.getProperty(key) : null;
    }
}
