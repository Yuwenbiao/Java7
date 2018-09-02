package Java7其他重要更新.Java实用工具类.对象操作;

import java.util.Objects;

/**
 * Objects类的equals方法的使用示例
 *
 * @author yuwb
 * @date 18-9-2 下午4:44
 */
public class Equals {
    public void equals() {
        boolean value1 = Objects.equals(new Object(), new Object());
        Object[] array1 = new Object[]{"Hello", 1, 1.0};
        Object[] array2 = new Object[]{"Hello", 1, 1.5};
        boolean value2 = Objects.deepEquals(array1, array2);
    }
}
