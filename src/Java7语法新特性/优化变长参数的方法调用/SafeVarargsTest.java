package Java7语法新特性.优化变长参数的方法调用;

/**
 * 使用@SafeVarargs注解一直编译器警告示例
 */
public class SafeVarargsTest {
    @SafeVarargs
    public static <T> T useVarargs(T... args) {
        return args.length > 0 ? args[0] : null;
    }
}
