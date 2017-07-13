/**
 * Aaron.ffp Inc.
 * Copyright (c) 范丰平（263869564@qq.com） 2017-2100 All Rights Reserved.
 */
package ffp.autotest.base.utils;

import java.util.Random;

import org.apache.jmeter.engine.util.CompoundVariable;

/**
 * <strong>随机工具类</strong><br><br>
 * <br>
 * @author FanFengping
 * @version V1.0.0: ffp-autotest-jmeter ffp.autotest.base.utils RandomUtil.java, 2016-04-30 21:34:12 Exp $
 */
public class RandomUtil {
    public RandomUtil() {
    }
    
    public String getRandomEnum(Object[] obj) {
        Random random = new Random();
        CompoundVariable[] enumVars;
        
        CompoundVariable[] values = (CompoundVariable[]) obj;
        
        if (values.length < 3) {
            return values[0].execute().trim();
        }
        
        enumVars = new CompoundVariable[values.length - 1];
        
        for (int i = 0; i < enumVars.length; i++) {
            enumVars[i] = values[i];
        }
        
        return enumVars[random.nextInt(enumVars.length)].execute().trim();
    }
}
