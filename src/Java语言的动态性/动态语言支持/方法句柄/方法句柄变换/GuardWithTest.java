package Java语言的动态性.动态语言支持.方法句柄.方法句柄变换;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * guardWithTest方法的使用示例
 */
public class GuardWithTest {
    public static boolean guardTest() {
        return Math.random() > 0.5;
    }

    public void guardWithTest() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        MethodHandle mhTest = lookup.findStatic(GuardWithTest.class, "guardTest", MethodType.methodType(boolean.class));
        MethodType type = MethodType.methodType(int.class, int.class, int.class);
        MethodHandle mhTarget = lookup.findStatic(Math.class, "max", type);
        MethodHandle mhFallback = lookup.findStatic(Math.class, "min", type);
        MethodHandle mh = MethodHandles.guardWithTest(mhTest, mhTarget, mhFallback);

        int value = (int) mh.invoke(3, 5);//值随机为3或5
    }
}
