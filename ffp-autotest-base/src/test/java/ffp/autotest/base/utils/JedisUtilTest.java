package ffp.autotest.base.utils;

import org.testng.annotations.Test;

public class JedisUtilTest {
    @Test
    public static void test() {
        JedisUtil redis = new JedisUtil("192.168.1.121", 6378, 10000, "fanfengping123", 0);
        
        System.out.println(redis.get("message"));
        
        System.out.println(redis.get("test"));
        
        System.out.println(redis.get("host"));
        System.out.println(redis.get("port"));
        System.out.println(redis.get("timeout"));
        System.out.println(redis.get("auth"));
        System.out.println(redis.get(""));
        
        System.out.println(redis.exists("host"));
        System.out.println(redis.exists("hosts"));
        System.out.println(redis.exists("host", "timeout", "time", "auth", ""));
        
        redis.mset("a1", "b1", "a2", "b2", "a3", "b3", "a4", "b4");
        System.out.println(redis.get("a1"));
        System.out.println(redis.get("a2"));
        System.out.println(redis.get("b1"));
        
        redis.close();
        
    }
}
