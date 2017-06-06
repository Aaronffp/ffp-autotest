/**
 * Aaron.ffp Inc.
 * Copyright (c) 范丰平(263869564@qq.com) 2017-2100 All Rights Reserved.
 */
package ffp.autotest.jmeter.functions;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.functions.AbstractFunction;
import org.apache.jmeter.functions.InvalidVariableException;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;
import org.apache.jmeter.threads.JMeterVariables;

import ffp.autotest.base.utils.JedisUtil;

/**
 * <strong>获取Map</strong><br>
 * 
 * @author FanFengping
 * @version V1.0.0: ffp-autotest-jmeter ffp.autotest.jmeter.functions JedisHgetFunction.java Exp $
 */
public class JedisHgetFunction extends AbstractFunction {
    private static final List<String> desc = new LinkedList<String>();
    private static final String       KEY  = "__REDIS_HGET";
    
    private CompoundVariable[] values;
    
    private static final int MIN_PARAM_COUNT = 6;
    private static final int MAX_PARAM_COUNT = 6;
    
    static {
        desc.add("Redis host");
        desc.add("Redis port");
        desc.add("Redis password");
        desc.add("Redis database");
        desc.add("Redis key");
        desc.add("Name of variable in which to store the result (optional)");
    }

    public JedisHgetFunction() {
        super();
    }

    @Override
    public String execute(SampleResult arg0, Sampler arg1) throws InvalidVariableException {JMeterVariables localJMeterVariables = getVariables();
        String host = ((CompoundVariable) this.values[0]).execute().trim();
        int port = Integer.parseInt(((CompoundVariable) this.values[1]).execute().trim());
        String password = ((CompoundVariable) this.values[2]).execute().trim();
        int database = Integer.parseInt(((CompoundVariable) this.values[3]).execute().trim());
        String key = ((CompoundVariable) this.values[4]).execute().trim();
        
        String storeName  = ((CompoundVariable) this.values[5]).execute().trim();
        
        JedisUtil redis = new JedisUtil(host, port, 5000, password, database);
        
        String storeValue = redis.hget(key).toString();
        
        redis.close();
        
        localJMeterVariables.put(storeName, storeValue);
        
        return storeValue;
    }
    
    @Override
    public List<String> getArgumentDesc() {
        return desc;
    }

    @Override
    public String getReferenceKey() {
        return KEY;
    }

    @Override
    public void setParameters(Collection<CompoundVariable> arg0) throws InvalidVariableException {
        checkParameterCount(arg0, MIN_PARAM_COUNT, MAX_PARAM_COUNT);
        
        this.values = arg0.toArray(new CompoundVariable[arg0.size()]);
    }

}
