package Java语言的动态性.动态语言支持.方法句柄.使用方法句柄进行函数式编程;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * 使用方法句柄实现的柯里化
 */
public class Curry {
    public static MethodHandle curry(MethodHandle handle, int value) {
        return MethodHandles.insertArguments(handle, 0, value);
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int add5(int a) throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        MethodType type = MethodType.methodType(int.class, int.class, int.class);
        MethodHandle mhAdd = lookup.findStatic(Curry.class, "add", type);

        MethodHandle mh = curry(mhAdd, 5);
        return (int) mh.invoke(a);
    }
}
