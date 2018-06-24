package Java语言的动态性.动态语言支持.invokedynamic指令.动态调用点;

import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * ConstantCallSite的使用示例
 */
public class UseConstantCallSite {
    public void useConstantCallSite() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        MethodType type = MethodType.methodType(String.class, int.class, int.class);
        MethodHandle mh = lookup.findVirtual(String.class, "substring", type);

        ConstantCallSite callSite = new ConstantCallSite(mh);
        MethodHandle invoker = callSite.dynamicInvoker();
        String result = (String) invoker.invoke("Hello", 2, 3);
    }
}
