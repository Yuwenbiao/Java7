package Java语言的动态性.动态代理.基本使用方式;

import java.lang.reflect.Proxy;

/**
 * 客户端代码
 */
public class SimpleProxy {
    public static void useProxy() {
        String str = "Hello World";
        LoggingInvocationHandler handler = new LoggingInvocationHandler(str);
        Comparable obj = (Comparable) Proxy.newProxyInstance(SimpleProxy.class.getClassLoader(), new Class[]{Comparable.class}, handler);
        System.out.println(obj.compareTo("Good"));
    }

    public static void main(String[] args) {
        useProxy();
    }
}
