/**
 * Aaron.ffp Inc.
 * Copyright (c) 范丰平(263869564@qq.com) 2017-2100 All Rights Reserved.
 */
package ffp.autotest.base.utils;

import java.util.List;
import java.util.Map;

import redis.clients.jedis.Jedis;

/**
 * <strong>Redis工具类</strong><br>
 * 
 * @author FanFengping
 * @version V1.0.0: ffp-autotest-base ffp.autotest.base.utils JedisUtil.java  Exp $
 */
public class JedisUtil {
    private Jedis redis;
    
    private String host = "";
    private int port = 6379;
    private int timeout = 5000;
    private String password = "";
    private int dbIndex = 0;
    
    public JedisUtil() {
    }
    
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
    
    public boolean hexists(String key, String field) {
        return this.redis.hexists(key, field);
    }
    
    public Long exists(String... keys) {
        return this.redis.exists(keys);
    }

    public boolean exists(String key) {
        return this.redis.exists(key);
    }
    
    public List<String> hmget(String key, String... fields) {
        return this.redis.hmget(key, fields);
    }
    
    public String hmset(String key, Map<String, String> hash) {
        return this.redis.hmset(key, hash);
    }
    
    public Map<String, String> hget(String key) {
        return this.redis.hgetAll(key);
    }
    
    public Long hset(String key, String field, String value) {
        return this.redis.hset(key, field, value);
    }
    
    public List<String> mget(String...keys) {
        return this.redis.mget(keys);
    }
    
    public void mset(String...keysvalues) {
        this.redis.mset(keysvalues);
    }
    
    public String get(String key) {
        return this.redis.get(key);
    }
    
    public void set(String key, String value) {
        this.redis.set(key, value);
    }
    
    public void close(){
        this.redis.close();
    }

    /**
     * Getter method for property <tt>redis</tt>.
     * 
     * @return property value of redis
     */
    public Jedis getRedis() {
        return redis;
    }

    /**
     * Setter method for property <tt>redis</tt>.
     * 
     * @param redis value to be assigned to property redis
     */
    public void setRedis(Jedis redis) {
        this.redis = redis;
    }

    /**
     * Getter method for property <tt>host</tt>.
     * 
     * @return property value of host
     */
    public String getHost() {
        return host;
    }

    /**
     * Setter method for property <tt>host</tt>.
     * 
     * @param host value to be assigned to property host
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * Getter method for property <tt>port</tt>.
     * 
     * @return property value of port
     */
    public int getPort() {
        return port;
    }

    /**
     * Setter method for property <tt>port</tt>.
     * 
     * @param port value to be assigned to property port
     */
    public void setPort(int port) {
        this.port = port;
    }

    /**
     * Getter method for property <tt>timeout</tt>.
     * 
     * @return property value of timeout
     */
    public int getTimeout() {
        return timeout;
    }

    /**
     * Setter method for property <tt>timeout</tt>.
     * 
     * @param timeout value to be assigned to property timeout
     */
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    /**
     * Getter method for property <tt>password</tt>.
     * 
     * @return property value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for property <tt>password</tt>.
     * 
     * @param password value to be assigned to property password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter method for property <tt>dbIndex</tt>.
     * 
     * @return property value of dbIndex
     */
    public int getDbIndex() {
        return dbIndex;
    }

    /**
     * Setter method for property <tt>dbIndex</tt>.
     * 
     * @param dbIndex value to be assigned to property dbIndex
     */
    public void setDbIndex(int dbIndex) {
        this.dbIndex = dbIndex;
    }
}
