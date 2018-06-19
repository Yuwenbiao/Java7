package Java语言的动态性.反射API.获取构造方法;

import java.lang.reflect.Constructor;

/**
 * 使用反射API获取参数长度可变的构造方法
 */
public class VarargsConstructor {
    public VarargsConstructor(String... names) {

    }

    public void useVarargsConstructor() throws Exception {
        Constructor<VarargsConstructor> constructor = VarargsConstructor.class.getDeclaredConstructor(String[].class);
        constructor.newInstance((Object) new String[]{"A", "B", "C"});
    }
}
