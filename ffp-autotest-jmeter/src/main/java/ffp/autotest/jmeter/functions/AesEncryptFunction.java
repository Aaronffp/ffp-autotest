/**
 * Aaron.ffp Inc.
 * Copyright (c) 范丰平（263869564@qq.com） 2017-2100 All Rights Reserved.
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

import ffp.autotest.base.crypt.AESCrypt;

/**
 * <strong>AES加密函数扩展</strong><br>
 * 
 * @author FanFengping
 * @version V1.0.0: ffp-autotest-jmeter ffp.autotest.jmeter.functions AesEncryptFunction.java, 2017-04-30 23:14:24 Exp $
 */
public class AesEncryptFunction extends AbstractFunction {

    private static final List<String> desc = new LinkedList<String>();
    private static final String       KEY  = "__AES";
    
    // 参数配置信息
    static {
        desc.add("AES encrypt key");
        desc.add("String to encrypt content");
        desc.add("String Charset");
        desc.add("Name of variable in which to store the result (optional)");
    }
    
    private CompoundVariable[] values;
    
    private static final int MIN_PARAM_COUNT = 4;
    private static final int MAX_PARAM_COUNT = 4;

    public AesEncryptFunction(){
        super();
    }
    
    // 函数执行，返回结果
    @Override
    public String execute(SampleResult previousResult, Sampler currentSampler) throws InvalidVariableException {
        JMeterVariables localJMeterVariables = getVariables();
        
        String encryptKey = ((CompoundVariable) this.values[0]).execute().trim();
        String content = ((CompoundVariable) this.values[1]).execute().trim();
        String charset = ((CompoundVariable) this.values[2]).execute().trim();
        
        charset = "".equals(charset) ? "UTF-8" : charset;

        AESCrypt aesc = new AESCrypt(encryptKey, charset);
        
        String storeName  = ((CompoundVariable) this.values[3]).execute().trim();
        String storeValue = aesc.encrypt(content); 
        
        localJMeterVariables.put(storeName, storeValue);
        
        return storeValue;
    }
    
    // 设置参数
    @Override
    public synchronized void setParameters(Collection<CompoundVariable> parameters) throws InvalidVariableException {
        // 参数个数检查：参数数量
        // checkMinParameterCount(parameters, 4);
        // 参数个数检查：参数数量范围
        checkParameterCount(parameters, MIN_PARAM_COUNT, MAX_PARAM_COUNT);
        
        this.values = parameters.toArray(new CompoundVariable[parameters.size()]);
    }
    
    // 获取函数应用关键字
    @Override
    public String getReferenceKey() {
        return KEY;
    }
    
    // 获取描述参数
    @Override
    public List<String> getArgumentDesc() {
        return desc;
    }
}
