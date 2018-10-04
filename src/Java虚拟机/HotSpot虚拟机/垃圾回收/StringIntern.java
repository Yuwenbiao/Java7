package Java虚拟机.HotSpot虚拟机.垃圾回收;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 由于字符串内部化机制造成内存不足的示例
 *
 * @author yuwb@corp.21cn.com
 * @date 2018/10/4 19:06
 */
public class StringIntern {
    private List<String> list = new ArrayList<>();

    public void useInternString() {
        Random random = new Random();
        for (int i = 0; i < 200; i++) {
            char[] data = new char[128 * 1024];
            for (int j = 0; j < data.length; j++) {
                data[j] = (char) random.nextInt(32768);
            }
            list.add((new String(data)).intern());
        }
    }
}
