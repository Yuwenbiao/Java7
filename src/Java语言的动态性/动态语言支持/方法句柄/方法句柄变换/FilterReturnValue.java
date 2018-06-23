package Java语言的动态性.动态语言支持.方法句柄.方法句柄变换;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * filterReturnValue方法的使用示例
 */
public class FilterReturnValue {
    public void filterReturnValue() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        MethodHandle mhSubstring = lookup.findVirtual(String.class, "substring", MethodType.methodType(String.class, int.class));
        MethodHandle mhUpperCase = lookup.findVirtual(String.class, "toUpperCase", MethodType.methodType(String.class));
        MethodHandle mh = MethodHandles.filterReturnValue(mhSubstring, mhUpperCase);

        String str = (String) mh.invoke("Hello World", 5);//输出为WORLD
    }
}
