package Java语言的动态性.动态代理.基本使用方式;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 被代理的接口中包含声明类型相同的方法的示例
 */
public class MultipleInterfacesProxy {
    public static void proxyMultipleInterfaces() throws Throwable {
        List<String> receiverObj = new ArrayList<>();
        ClassLoader cl = MultipleInterfacesProxy.class.getClassLoader();
        LoggingInvocationHandler handler = new LoggingInvocationHandler(receiverObj);
        Class<?> proxyClass = Proxy.getProxyClass(cl, new Class<?>[]{List.class, Set.class});
        Object proxy = proxyClass.getConstructor(new Class[]{InvocationHandler.class}).newInstance(new Object[]{handler});
        List list = (List) proxy;
        list.add("Hello");
        Set set = (Set) proxy;
        set.add("World");
    }

    public static void main(String[] args) throws Throwable {
        proxyMultipleInterfaces();
    }
}
