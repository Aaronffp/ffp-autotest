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

import ffp.autotest.base.utils.RandomUtil;

/**
 * <strong>枚举类型随机函数</strong><br><br>
 * <br>
 * @author FanFengping
 * @version V1.0.0: ffp-autotest-jmeter ffp.autotest.jmeter.functions RandomEnumFunction.java, 2015-04-30 21:44:42 Exp $
 */
public class RandomEnumFunction extends AbstractFunction {
    private static final List<String> desc            = new LinkedList<String>();
    private static final String       KEY             = "__RandomEnum";
    private static final int          MIN_PARAM_COUNT = 2;
    private static final int          MAX_PARAM_COUNT = 50;
    private CompoundVariable[]        values;

    public RandomEnumFunction() {
        super();
    }

    static {
        desc.add("Enum list(split by comma)");
        desc.add("Name of variable in which to store the result (optional)");
    }

    @Override
    public String execute(SampleResult previousResult, Sampler currentSampler) throws InvalidVariableException {
        JMeterVariables localJMeterVariables = getVariables();
        String variableName  = "";
        String variableValue = "";

        variableName = ((CompoundVariable) this.values[this.values.length - 1]).execute().trim();
        
        variableValue = RandomUtil.getRandomEnum(this.values); 

        localJMeterVariables.put(variableName, variableValue);

        return variableValue;
    }
    
    @Override
    public synchronized void setParameters(Collection<CompoundVariable> parameters) throws InvalidVariableException {
        checkParameterCount(parameters, MIN_PARAM_COUNT, MAX_PARAM_COUNT);

        this.values = parameters.toArray(new CompoundVariable[parameters.size()]);
    }

    @Override
    public String getReferenceKey() {
        return KEY;
    }

    @Override
    public List<String> getArgumentDesc() {
        return desc;
    }
}
