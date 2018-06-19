package Java语言的动态性.反射API;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 使用反射API设置对象的属性值的实例
 */
public class ReflectSetter {
    public static void invokeSetter(Object obj, String field, Object value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String methodName = "set" + field.substring(0, 1).toUpperCase() + field.substring(1);//设置方法名
        Class<?> clazz = obj.getClass();//获得对象的类型
        Method method = clazz.getMethod(methodName, value.getClass());//获取方法名以及方法参数类型

        method.invoke(obj, value);//方法调用
    }
}
