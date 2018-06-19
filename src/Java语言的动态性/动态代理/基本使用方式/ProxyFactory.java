package Java语言的动态性.动态代理.基本使用方式;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * 为任何接口及其实现类创建代理的工厂方法
 */
public class ProxyFactory {
    public static void main(String[] args) {
        useGenericProxy();
    }

    public static <T> T makeProxy(Class<T> intf, final T object) {
        LoggingInvocationHandler handler = new LoggingInvocationHandler(object);
        ClassLoader d = object.getClass().getClassLoader();
        return (T) Proxy.newProxyInstance(d, new Class<?>[]{intf}, handler);
    }

    /**
     * 创建代理对象的工厂方法的使用示例
     */
    public static void useGenericProxy() {
        String str = "Hello World";
        Comparable proxy = makeProxy(Comparable.class, str);
        proxy.compareTo("Good");
        List<String> list = new ArrayList<>();
        list = makeProxy(List.class, list);
        list.add("Hello");
    }

    /**
     * 代理某个类所实现的所有接口
     */
    public static Object proxyAll(final Object object) {
        LoggingInvocationHandler handler = new LoggingInvocationHandler(object);
        ClassLoader cl = object.getClass().getClassLoader();
        Class<?>[] interfaces = object.getClass().getInterfaces();
        return Proxy.newProxyInstance(cl, interfaces, handler);
    }
}
