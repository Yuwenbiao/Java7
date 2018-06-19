package Java语言的动态性.反射API.获取方法;

import java.lang.reflect.Method;

/**
 * 使用反射API获取和使用公开和私有方法
 */
public class MethodContainer {
    public void publicMethod() {

    }

    private void privateMethod() {

    }

    public void useMethod() throws Exception {
        MethodContainer mc = new MethodContainer();
        Method publicMethod = MethodContainer.class.getDeclaredMethod("publicMethod");
        publicMethod.invoke(mc);

        Method privateMethod = MethodContainer.class.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);//注意设置可以访问的权限
        privateMethod.invoke(mc);
    }
}
