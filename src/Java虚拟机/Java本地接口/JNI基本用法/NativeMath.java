package Java虚拟机.Java本地接口.JNI基本用法;

/**
 * 包含原生方法的Java类
 *
 * @author yuwb
 * @date 18-9-23 上午9:26
 */
public class NativeMath {
    static {
        System.loadLibrary("NativeMath");
    }

    public native double sqrt(double value);
}
