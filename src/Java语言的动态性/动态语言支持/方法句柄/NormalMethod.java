package Java语言的动态性.动态语言支持.方法句柄;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class NormalMethod {
    public void normalMethod(String arg1, int arg2, int[] arg3) {

    }

    /**
     * asVarargsCollector方法的使用示例
     */
    public void asVarargsCollector() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh = lookup.findVirtual(NormalMethod.class, "normalMethod", MethodType.methodType(void.class, String.class, int.class, int[].class));
        mh = mh.asVarargsCollector(int[].class);

        mh.invoke(this, "Hello", 2, 3, 4, 5);
    }

    /**
     * asCollector方法的使用示例
     */
    public void asCollector() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh = lookup.findVirtual(NormalMethod.class, "normalMethod", MethodType.methodType(void.class, String.class, int.class, int[].class));
        mh = mh.asCollector(int[].class, 2);

        mh.invoke(this, "Hello", 2, 3, 4);
    }

    public void toBeSpreaded(String arg1, int arg2, int arg3, int arg4) {

    }

    /**
     * asSpreader方法的使用示例
     */
    public void asSpreader() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh = lookup.findVirtual(NormalMethod.class, "toBeSpreaded", MethodType.methodType(void.class, String.class, int.class, int.class, int.class));
        mh = mh.asSpreader(int[].class, 3);

        mh.invoke(this, "Hello", new int[]{3, 4, 5});
    }

    public void varargsMethod(String arg1, int... args) {

    }

    /**
     * asFixedArity方法的使用示例
     */
    public void asFixedArity() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh = lookup.findVirtual(NormalMethod.class, "varargsMethod", MethodType.methodType(void.class, String.class, int[].class));
        mh = mh.asFixedArity();

        mh.invoke(this, "Hello", new int[]{2, 4});
    }


}
