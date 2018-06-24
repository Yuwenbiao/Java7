package Java语言的动态性.动态语言支持.invokedynamic指令.invokedynamic指令实战;

import java.lang.invoke.*;

/**
 * invokedynamic指令的启动方法
 */
public class ToUpperCase {
    public static CallSite bootstrap(MethodHandles.Lookup lookup, String name, MethodType type, String value) throws Exception {
        MethodHandle mh = lookup.findVirtual(String.class, "toUpperCase", MethodType.methodType(String.class)).bindTo(value);
        return new ConstantCallSite(mh);
    }
}
