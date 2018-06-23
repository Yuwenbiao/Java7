package Java语言的动态性.动态语言支持.方法句柄.方法句柄变换;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * catchException方法的使用示例
 */
public class CatchException {
    public int handleException(Exception e, String str) {
        System.out.println(e.getMessage());
        return 0;
    }

    public void catchException() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        MethodType typeTarget = MethodType.methodType(int.class, String.class);
        MethodHandle mhParseInt = lookup.findStatic(Integer.class, "parseInt", typeTarget);

        MethodType typeHandler = MethodType.methodType(int.class, Exception.class, String.class);
        MethodHandle mhHandler = lookup.findVirtual(CatchException.class, "handleException", typeHandler).bindTo(this);

        MethodHandle mh = MethodHandles.catchException(mhParseInt, NumberFormatException.class, mhHandler);
        mh.invoke("Hello");
    }
}
