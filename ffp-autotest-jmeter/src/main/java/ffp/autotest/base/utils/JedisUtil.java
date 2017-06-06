/**
 * Aaron.ffp Inc.
 * Copyright (c) 范丰平（263869564@qq.com） 2017-2100 All Rights Reserved.
 */
package ffp.autotest.base.utils;

import java.util.Map;

import redis.clients.jedis.Jedis;

/**
 * <strong>Jedis工具类</strong><br>
 * 
 * @author FanFengping
 * @version V1.0.0: ffp-autotest-jmeter ffp.autotest.base.utils JedisUtil.java, 2017年5月18日 下午9:30:51 Exp $
 */
public class JedisUtil {
    private Jedis redis;
    
    private String host = "";
    private int port = 6379;
    private int timeout = 5000;
    private String password = "";
    private int dbIndex = 0;
    
    /**
     * <strong>构造函数</strong><br>
     * 
     * @author FanFengping
     * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils JedisUtil.java Exp $
     * 
     * @param host 地址
     * @param port 端口（若非法，则默认为6379）
     * @param timeout 连接超时时间（若非法，则默认5000ms）
     * @param password 密码
     * @param dbIndex 数据库索引（若非法，则默认为0）
     */
    public JedisUtil(String host, int port, int timeout, String password, int dbIndex) {
        super();
        this.host = host;
        this.port = StringUtil.isNull(String.valueOf(port)) ? port : 6379;
        this.timeout = StringUtil.isNull(String.valueOf(timeout)) ? timeout : 5000;
        this.password = password;
        this.dbIndex = StringUtil.isNull(String.valueOf(dbIndex)) ? dbIndex : 0;
        
        this.redis = new Jedis(this.host, this.port, this.timeout);
        this.redis.auth(this.password);
        this.redis.select(this.dbIndex);
    }
    
    public Map<String, String> hget(String key) {
        return this.redis.hgetAll(key);
    }
    
    public String get(String key) {
        return this.redis.get(key);
    }
    
    public void close(){
        this.redis.close();
    }

}
