/**
 * Aaron.ffp Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package ffp.autotest.base.crypt;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * <strong>AES测试类</strong><br><br>
 * <br>
 * @author FanFengping
 * @version V1.0.0: ffp-autotest-base ffp.autotest.base.crypt AESCryptTest.java, 2017年4月30日 上午12:11:27 Exp $
 */
public class AESCryptTest {

    @Test
    public static void encrypt() {
        String encryptKey = "123456";
        String content = "123456";
        
        Assert.assertEquals(AESCrypt.encrypt(encryptKey, content, "UTF-8"), "OQXvThGuGqlPHR9GA/i1tg==");
    }

    @Test
    public static void decrypt() {
        String encryptKey = "明天";
        String content = "1XBLtYEqgbXvLOpjjEDppw==";
        
        Assert.assertEquals(AESCrypt.decrypt(encryptKey, content, "UTF-8"), "123456");
    }

}
