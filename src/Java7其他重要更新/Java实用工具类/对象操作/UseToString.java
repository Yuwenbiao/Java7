package Java7其他重要更新.Java实用工具类.对象操作;

import java.util.Objects;

/**
 * Objects类的toString方法的使用示例
 *
 * @author yuwb
 * @date 18-9-2 下午4:51
 */
public class UseToString {
    public void useToString() {
        String str1 = Objects.toString("Hello");
        String str2 = Objects.toString(null, "空对象");
    }
}
