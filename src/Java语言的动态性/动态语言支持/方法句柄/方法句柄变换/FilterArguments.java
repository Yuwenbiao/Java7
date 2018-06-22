package Java语言的动态性.动态语言支持.方法句柄.方法句柄变换;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * filterArguments方法的使用示例
 */
public class FilterArguments {
    public void filterArguments() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType type = MethodType.methodType(int.class, int.class, int.class);

        MethodHandle mhGetLength = lookup.findVirtual(String.class, "length", MethodType.methodType(int.class));
        MethodHandle mhTarget = lookup.findStatic(Math.class, "max", type);
        MethodHandle mhNew = MethodHandles.filterArguments(mhTarget, 0, mhGetLength, mhGetLength);

        int value = (int) mhNew.invoke("Hello", "New World");//值为9
    }
}
