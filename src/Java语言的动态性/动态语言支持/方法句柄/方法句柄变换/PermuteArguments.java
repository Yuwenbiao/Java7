package Java语言的动态性.动态语言支持.方法句柄.方法句柄变换;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * permuteArguments方法的使用示例
 */
public class PermuteArguments {
    public void permuteArguments() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodType type = MethodType.methodType(int.class, int.class, int.class);

        MethodHandle mhCompare = lookup.findStatic(Integer.class, "compare", type);
        int value = (int) mhCompare.invoke(3, 4);//值为-1

        MethodHandle mhNew = MethodHandles.permuteArguments(mhCompare, type, 1, 0);
        value = (int) mhNew.invoke(3, 4);//值为1

        MethodHandle mhDuplicateArgs = MethodHandles.permuteArguments(mhCompare, type, 1, 1);
        value = (int) mhDuplicateArgs.invoke(3, 4);//值为0
    }
}
