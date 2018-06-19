package Java语言的动态性.动态语言支持.方法句柄;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * 使用invokeExact方法调用方法句柄
 */
public class InvokeExact {
    public static void main(String[] args) {
        try {
            invokeExact();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    private static void invokeExact() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType type = MethodType.methodType(String.class, int.class, int.class);
        MethodHandle mh = lookup.findVirtual(String.class, "substring", type);
        String str = (String) mh.invokeExact("Hello World", 1, 3);

        System.out.println(str);
    }
}
