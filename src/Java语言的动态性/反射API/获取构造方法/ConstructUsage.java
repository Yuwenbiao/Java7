package Java语言的动态性.反射API.获取构造方法;

import java.lang.reflect.Constructor;

/**
 * 使用反射API获取嵌套类的构造方法
 */
public class ConstructUsage {
    static class StaticNestedClass {
        public StaticNestedClass(String name) {

        }
    }

    class NestedClass {
        public NestedClass(int count) {
        }
    }

    public void useNestedClassConstructor() throws Exception {
        Constructor<StaticNestedClass> sncc = StaticNestedClass.class.getDeclaredConstructor(String.class);
        sncc.newInstance("Alex");

        //获取非静态内部类，注意类型参数列表的第一个值必须是外部类的Class对象
        Constructor<NestedClass> ncc = NestedClass.class.getDeclaredConstructor(ConstructUsage.class, int.class);
        NestedClass ic = ncc.newInstance(this, 3);
    }
}
