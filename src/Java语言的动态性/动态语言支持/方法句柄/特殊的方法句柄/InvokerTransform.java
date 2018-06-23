package Java语言的动态性.动态语言支持.方法句柄.特殊的方法句柄;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * invoker和exactInvoker对方法句柄变换的影响
 */
public class InvokerTransform {
    public void invokerTransform() throws Throwable {
        MethodType typeInvoker = MethodType.methodType(String.class, String.class, int.class, int.class);
        MethodHandle invoker = MethodHandles.exactInvoker(typeInvoker);

        MethodHandles.Lookup lookup = MethodHandles.lookup();

        MethodHandle mhUpperCase = lookup.findVirtual(String.class, "toUpperCase", MethodType.methodType(String.class));
        invoker = MethodHandles.filterReturnValue(invoker, mhUpperCase);

        MethodType typeFind = MethodType.methodType(String.class, int.class, int.class);
        MethodHandle mh1 = lookup.findVirtual(String.class, "substring", typeFind);

        String result = (String) invoker.invoke(mh1, "Hello", 1, 4);//值为ELL
    }
}
