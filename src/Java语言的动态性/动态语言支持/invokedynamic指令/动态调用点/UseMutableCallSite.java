package Java语言的动态性.动态语言支持.invokedynamic指令.动态调用点;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.MutableCallSite;

/**
 * MutableCallSite的使用示例
 */
public class UseMutableCallSite {
    public void useMutableCallSite() throws Throwable {
        MethodType type = MethodType.methodType(int.class, int.class, int.class);
        MutableCallSite callSite = new MutableCallSite(type);

        MethodHandle invoker = callSite.dynamicInvoker();
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        MethodHandle mhMax = lookup.findStatic(Math.class, "max", type);
        MethodHandle mhMin = lookup.findStatic(Math.class, "min", type);

        callSite.setTarget(mhMax);
        int result = (int) invoker.invoke(3, 5);//值为5
        callSite.setTarget(mhMin);
        result = (int) invoker.invoke(3, 5);//值为3
    }
}
