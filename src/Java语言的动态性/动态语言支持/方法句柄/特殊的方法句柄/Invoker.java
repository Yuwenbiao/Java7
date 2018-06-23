package Java语言的动态性.动态语言支持.方法句柄.特殊的方法句柄;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * invoker方法的使用示例
 */
public class Invoker {
    public void invoker() throws Throwable {
        MethodType typeInvoker = MethodType.methodType(String.class, Object.class, int.class, int.class);
        MethodHandle invoker = MethodHandles.invoker(typeInvoker);

        MethodType typeFind = MethodType.methodType(String.class, int.class, int.class);

        MethodHandles.Lookup lookup = MethodHandles.lookup();

        MethodHandle mh1 = lookup.findVirtual(String.class, "substring", typeFind);
        MethodHandle mh2 = lookup.findVirtual(InvokerUsage.class, "testMethod", typeFind);

        String result = (String) invoker.invoke(mh1, "Hello", 2, 3);
        result = (String) invoker.invoke(mh2, this, 2, 3);
    }

    private class InvokerUsage {
        String testMethod(int a, int b) {
            return "";
        }
    }
}
