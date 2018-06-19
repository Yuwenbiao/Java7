package Java语言的动态性.动态代理.使用案例;

import java.lang.reflect.Proxy;

/**
 * 进行对象转换的工厂方法
 */
public class GreetFactory {
    public static GreetV2 adaptGreet(GreetV1 greetV1) {
        GreetAdapter adapter = new GreetAdapter(greetV1);
        ClassLoader cl = greetV1.getClass().getClassLoader();
        return (GreetV2) Proxy.newProxyInstance(cl, new Class<?>[]{GreetV2.class}, adapter);
    }
}
