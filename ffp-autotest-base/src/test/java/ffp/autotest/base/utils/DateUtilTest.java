package ffp.autotest.base.utils;

import org.testng.annotations.Test;

public class DateUtilTest {

    @Test
    public static void getDateTime() {
        System.out.println(DateUtil.getDateTime("yyyyMMdd-HHmm"));
    }

    @Test
    public static void getDefault() {
        System.out.println(DateUtil.getDefault());
    }

    @Test
    public static void getHHMMSS() {
        System.out.println(DateUtil.getHHMMSS());
    }

    @Test
    public static void getHMS() {
        System.out.println(DateUtil.getHMS());
    }

    @Test
    public static void getYMD() {
        System.out.println(DateUtil.getYMD());
    }

    @Test
    public static void getYYYYMMDD() {
        System.out.println(DateUtil.getYYYYMMDD());
    }
}
