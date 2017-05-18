/**
 * Aaron.ffp Inc.
 * Copyright (c) 2017-2100 All Rights Reserved.
 */
package ffp.autotest.base.variables;

import java.util.Properties;

/**
 * <strong></strong><br>
 * 
 * @author FanFengping
 * @version V1.0.0: ffp-autotest-base ffp.autotest.base.variables GlobalVariable.java, 2017-04-30 22:09:22 Exp $
 */
public class GlobalVariable {
    public static final Properties prop              = System.getProperties();

    public static final String     USER_NAME         = prop.getProperty("user.name");         // Aaron
    public static final String     USER_HOME         = prop.getProperty("user.home");         // C:\Users\Aaron
    public static final String     USER_LANGUAGE     = prop.getProperty("user.language");     // zh
    public static final String     USER_COUNTRY      = prop.getProperty("user.country");      // CN
    public static final String     USER_TIMEZONE     = prop.getProperty("user.timezone");     // Asia/Shanghai

    public static final String     PROJECT_HOME      = prop.getProperty("user.dir");

    public static final String     JAVA_VERSION      = prop.getProperty("java.version");      // 1.8.0
    public static final String     JAVA_HOME         = prop.getProperty("java.home");         // C:\Java\jdk8\jre
    public static final String     JAVA_RUNTIME_NAME = prop.getProperty("java.runtime.name"); // Java(TM) SE Runtime Environment
    public static final String     JAVA_VM_NAME      = prop.getProperty("java.vm.name");      // Java HotSpot(TM) 64-Bit Server VM
    public static final String     JAVA_VM_VENDOR    = prop.getProperty("java.vm.vendor");    // Oracle Corporation

    public static final String     OS_NAME           = prop.getProperty("os.name");           // Windows 7
    public static final String     OS_ARCH           = prop.getProperty("os.arch");           // amd64
    public static final String     OS_VERSION        = prop.getProperty("os.version");        // 6.1

    public static final String     OS_FILE_SEPARATOR = prop.getProperty("file.separator");
    public static final String     OS_PATH_SEPARATOR = prop.getProperty("path.separator");
    public static final String     OS_LINE_SEPARATOR = prop.getProperty("line.separator");
}
