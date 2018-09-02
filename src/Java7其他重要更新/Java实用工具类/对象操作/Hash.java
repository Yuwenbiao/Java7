package Java7其他重要更新.Java实用工具类.对象操作;

import java.util.Objects;

/**
 * Objects类的hash和hashCode方法的使用示例
 *
 * @author yuwb
 * @date 18-9-2 下午4:48
 */
public class Hash {
    public void hash() {
        int hashCode1 = Objects.hashCode("Hello");
        int hashCode2 = Objects.hash("Hello", "World");
        int hashCode3 = Objects.hash("Hello");
    }
}
