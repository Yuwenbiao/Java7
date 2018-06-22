package Java语言的动态性.动态语言支持.方法句柄;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

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

    /**
     * 参数绑定的基本用法
     */
    public void bindTo() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh = lookup.findVirtual(String.class, "length", MethodType.methodType(int.class));

        int len = (int) mh.invoke("Hello");//值为5
        mh = mh.bindTo("Hello World");
        len = (int) mh.invoke();//值为11
    }

    /**
     * 多次参数绑定的示例
     */
    public void multipleBindTo() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh = lookup.findVirtual(String.class, "indexOf", MethodType.methodType(int.class, String.class, int.class));

        mh = mh.bindTo("Hello").bindTo("l");
        System.out.println(mh.invoke(2));//值为2
    }

    /**
     * 基本类型参数的绑定方式
     */
    public void baseBindTo() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh = lookup.findVirtual(String.class, "substring", MethodType.methodType(String.class, int.class, int.class));

        mh = mh.asType(mh.type().wrap());
        mh = mh.bindTo("Hello World").bindTo(3);
        System.out.println(mh.invoke(5));//值为“lo”
    }

    /**
     * 查找构造方法，一般方法和静态方法的方法句柄的示例
     */
    public void lookupMethod() throws NoSuchMethodException, IllegalAccessException {
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        //构造方法
        lookup.findConstructor(String.class, MethodType.methodType(void.class, byte[].class));

        //String.substring
        lookup.findVirtual(String.class, "substring", MethodType.methodType(String.class, int.class, int.class));

        //String.format
        lookup.findStatic(String.class, "format", MethodType.methodType(String.class, String.class, Object[].class));
    }

    /**
     * 查找类中特殊方法的方法句柄的示例
     */
    public MethodHandle lookupSpecial() throws NoSuchMethodException, IllegalAccessException, Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        return lookup.findSpecial(MethodHandleLookup.class, "privateMethod", MethodType.methodType(void.class), MethodHandleLookup.class);
    }

    private class MethodHandleLookup {
        private void privateMethod() {
        }
    }

    /**
     * 查找类中的静态域和一般域对应的获取和设置的方法句柄的示例
     */
    public void lookupFieldAccessor() throws NoSuchFieldException, IllegalAccessException {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        lookup.findGetter(Sample.class, "name", String.class);
        lookup.findSetter(Sample.class, "name", String.class);
        lookup.findStaticGetter(Sample.class, "value", int.class);
        lookup.findStaticSetter(Sample.class, "value", int.class);
    }

    private static class Sample {
        String name;
        static int value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}
