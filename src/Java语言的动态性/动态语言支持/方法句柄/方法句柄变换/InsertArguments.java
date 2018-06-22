package Java语言的动态性.动态语言支持.方法句柄.方法句柄变换;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * insertArguments方法的使用示例
 */
public class InsertArguments {
    public void insertArguments() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType type = MethodType.methodType(String.class, String.class);
        MethodHandle mhOld = lookup.findVirtual(String.class, "concat", type);

        String value = (String) mhOld.invoke("Hello", "World");
        MethodHandle mhNew = MethodHandles.insertArguments(mhOld, 1, "--");
        value = (String) mhNew.invoke("Hello");//值为“Hello--”
    }
}
