package Java语言的动态性.反射API.获取域;

import java.lang.reflect.Field;

/**
 * 使用反射API获取和使用静态域和实例域
 */
public class FieldContainer {
    public static int count;
    public String name;

    public void useField() throws Exception {
        Field fieldCount = FieldContainer.class.getDeclaredField("count");
        fieldCount.set(null, 3);//静态域不需要提供具体对象实例

        Field fieldName = FieldContainer.class.getDeclaredField("name");
        FieldContainer fieldContainer = new FieldContainer();
        fieldName.set(fieldContainer, "Bob");//非静态域需要提供具体对象实例
    }
}
