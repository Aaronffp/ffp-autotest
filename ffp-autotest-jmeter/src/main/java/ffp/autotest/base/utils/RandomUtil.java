package ffp.autotest.base.utils;

import java.util.Random;

import org.apache.jmeter.engine.util.CompoundVariable;

public class RandomUtil {
    public RandomUtil() {
    }
    
    public static String getRandomEnum(Object[] obj) {
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
