package Java语言的动态性.动态语言支持.方法句柄.方法句柄变换;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * foldArguments方法的使用示例
 */
public class FoldArguments {
    public static int targetMethod(int arg1, int arg2, int arg3) {
        return arg1;
    }

    public void foldArguments() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType typeCombiner = MethodType.methodType(int.class, int.class, int.class);

        MethodHandle mhCombiner = lookup.findStatic(Math.class, "max", typeCombiner);
        MethodType typeTarget = MethodType.methodType(int.class, int.class, int.class, int.class);
        MethodHandle mhTarget = lookup.findStatic(FoldArguments.class, "targetMethod", typeTarget);
        MethodHandle mhResult = MethodHandles.foldArguments(mhTarget, mhCombiner);
        int value = (int) mhResult.invoke(3, 4);//输出为4
    }

}
