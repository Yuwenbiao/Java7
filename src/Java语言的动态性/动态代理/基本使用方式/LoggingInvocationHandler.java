package Java语言的动态性.动态代理.基本使用方式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * InvocationHandler接口的实现类示例，代理类
 */
public class LoggingInvocationHandler implements InvocationHandler {
    private static final Logger LOGGER = Logger.getLogger(LoggingInvocationHandler.class.getName());
    private Object receiverObject;

    public LoggingInvocationHandler(Object receiverObject) {
        this.receiverObject = receiverObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        LOGGER.log(Level.INFO, "调用方法" + method.getName() + "; 参数为" + Arrays.deepToString(args));
        return method.invoke(receiverObject, args);
    }

}
