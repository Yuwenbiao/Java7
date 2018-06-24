package Java语言的动态性.动态语言支持.方法句柄.使用方法句柄进行函数式编程;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

/**
 * 使用方法句柄实现数组操作的示例
 */
public class OperationArray {
    private static final MethodType typeCallback = MethodType.methodType(Object.class, Object.class, int.class);

    public static void forEach(Object[] array, MethodHandle handle) throws Throwable {
        for (int i = 0, len = array.length; i < len; i++) {
            handle.invoke(array[i], i);
        }
    }

    public static Object[] map(Object[] array, MethodHandle handle) throws Throwable {
        Object[] result = new Object[array.length];
        for (int i = 0, len = array.length; i < len; i++) {
            result[i] = handle.invoke(array[i], i);
        }
        return result;
    }

    public static Object reduce(Object[] array, Object initalValue, MethodHandle handle) throws Throwable {
        Object result = initalValue;
        for (int i = 0, len = array.length; i < len; i++) {
            result = handle.invoke(result, array[i]);
        }
        return result;
    }
}
