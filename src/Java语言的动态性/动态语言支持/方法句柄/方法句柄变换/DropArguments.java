package Java语言的动态性.动态语言支持.方法句柄.方法句柄变换;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * dropArguments方法的使用示例
 */
public class DropArguments {
    public void dropArguments() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType type = MethodType.methodType(String.class, int.class, int.class);
        MethodHandle mhOld = lookup.findVirtual(String.class, "substring", type);
        String value = (String) mhOld.invoke("Hello", 2, 3);

        MethodHandle mhNew = MethodHandles.dropArguments(mhOld, 0, float.class, String.class);
        value = (String) mhNew.invoke(0.5f, "Ignore", "Hello", 2, 3);
    }
}
