package Java语言的动态性.动态代理.使用案例;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 完成接口适配的InvocationHandler接口的实现
 */
public class GreetAdapter implements InvocationHandler {
    private GreetV1 greetV1;

    public GreetAdapter(GreetV1 greetV1) {
        this.greetV1 = greetV1;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        if ("greet".equals(methodName)) {
            String username = (String) args[0];
            String name = findName(username);
            String gender = findGender(username);
            try {
                Method greetMethodV1 = GreetV1.class.getMethod(methodName, new Class<?>[]{String.class, String.class});
                return greetMethodV1.invoke(greetV1, new Object[]{name, gender});
            } catch (InvocationTargetException e) {
                Throwable cause = e.getCause();
                if (cause != null) {
                }
                throw e;
            }
        } else {
            return method.invoke(greetV1, args);
        }
    }

    private String findGender(String username) {
        return Math.random() > 0.5 ? username : null;
    }

    private String findName(String username) {
        return username;
    }
}
