package ffp.autotest.base.variables;

import org.testng.annotations.Test;

public class GlobalVariableTest {
    @Test
    public static void test() {
        System.out.println(GlobalVariable.USER_NAME);
        System.out.println(GlobalVariable.USER_HOME);
        System.out.println(GlobalVariable.USER_LANGUAGE);
        System.out.println(GlobalVariable.USER_COUNTRY);
        System.out.println(GlobalVariable.USER_TIMEZONE);

        System.out.println(GlobalVariable.PROJECT_HOME);

        System.out.println(GlobalVariable.JAVA_VERSION);
        System.out.println(GlobalVariable.JAVA_HOME);
        System.out.println(GlobalVariable.JAVA_RUNTIME_NAME);
        System.out.println(GlobalVariable.JAVA_VM_NAME);
        System.out.println(GlobalVariable.JAVA_VM_VENDOR);

        System.out.println(GlobalVariable.OS_NAME);
        System.out.println(GlobalVariable.OS_ARCH);
        System.out.println(GlobalVariable.OS_VERSION);

        System.out.println(GlobalVariable.OS_FILE_SEPARATOR);
        System.out.println(GlobalVariable.OS_PATH_SEPARATOR);
        System.out.println(GlobalVariable.OS_LINE_SEPARATOR);
    }
}
