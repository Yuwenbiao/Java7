package Java7其他重要更新.Java实用工具类.对象操作;

import java.util.Comparator;
import java.util.Objects;

/**
 * Objects类的compare方法的使用示例
 *
 * @author yuwb
 * @date 18-9-2 下午4:40
 */
public class ReverseComparator implements Comparator<Long> {
    @Override
    public int compare(Long o1, Long o2) {
        return o2.compareTo(o1);
    }

    public void compare() {
        int value1 = Objects.compare(1L, 2L, new ReverseComparator());
    }
}
