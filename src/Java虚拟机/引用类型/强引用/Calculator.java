package Java虚拟机.引用类型.强引用;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用缓存造成对象存活时间过长的示例
 * 在calculate方法被调用多次之后，缓存的对象越来越多，导致占用的内存越来越大。
 *
 * @author yuwb
 * @date 2018/9/17 16:01
 */
public class Calculator {
    private Map<String, Object> cache = new HashMap<>();

    public Object calculate(String expr) {
        if (cache.containsKey(expr)) {
            return cache.get(expr);
        }
        Object result = doCalculate(expr);
        cache.put(expr, result);
        return result;
    }

    private Object doCalculate(String expr) {
        return new Object();
    }
}
