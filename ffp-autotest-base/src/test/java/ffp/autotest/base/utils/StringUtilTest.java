package ffp.autotest.base.utils;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StringUtilTest {

    @Test
    public static void empty() {
        Assert.assertEquals(StringUtil.empty(null, "empty"), "empty");
    }

    @Test
    public static void isEmpty() {
        Assert.assertTrue(StringUtil.isEmpty(""));
    }

    @Test
    public static void isNull() {
        Assert.assertTrue(StringUtil.isNull(null));
    }

    @Test
    public static void isNumeric() {
        Assert.assertFalse(StringUtil.isNumeric("123412a50352345025623"));
    }

    @Test
    public static void lower() {
        Assert.assertEquals(StringUtil.lower("FanFengping"), "fanfengping");
    }

    @Test
    public static void padEnd() {
        Assert.assertEquals(StringUtil.padEnd("Fan", 20, "*#*"), "Fan*#**#**#**#**#**#*");
    }

    @Test
    public static void padStart() {
        Assert.assertEquals(StringUtil.padStart("Fan", 21, "*#*"), "*#**#**#**#**#**#*Fan");
    }

    @Test
    public static void repeat() {
        Assert.assertEquals(StringUtil.repeat("Fan", 7), "FanFanFanFanFanFanFan");
    }

    @Test
    public static void split() {
        Assert.assertEquals(StringUtil.split("FanxxFanxxFanxxFanxxFanxxFanxxFan", "xx").size(), 7);
    }

    @Test
    public static void splitPattern() {
        Assert.assertEquals(StringUtil.splitPattern("FanaFanbFancFan*Fan#Fan=Fan", "n[ac=]F").size(), 4);
    }

    @Test
    public static void upper() {
        Assert.assertEquals(StringUtil.upper("FanFengping"), "FANFENGPING");
    }
}
