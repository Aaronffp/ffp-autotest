/**
 * Aaron.ffp Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package ffp.autotest.base.crypt;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * <strong>MD5测试工具类</strong><br><br>
 * <br>
 * @author FanFengping
 * @version V1.0.0: ffp-autotest-base ffp.autotest.base.crypt MD5CryptTest.java, 2017年4月30日 上午8:45:24 Exp $
 */
public class MD5CryptTest {
    @Test
    public static void md16() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String content = "fanfengping";
        String charset = "UTF-8";
        
        Assert.assertEquals(MD5Crypt.encrypt16(content, charset), "d7cb99e81888176d");
    }
    
    @Test
    public static void md32() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String content = "fanfengping";
        String charset = "UTF-8";
        
        Assert.assertEquals(MD5Crypt.encrypt(content, charset), "ec570e22d7cb99e81888176d5dd96390");
    }

}
