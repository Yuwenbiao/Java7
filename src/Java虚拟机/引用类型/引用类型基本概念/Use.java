package Java虚拟机.引用类型.引用类型基本概念;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * 引用对象的通常做法
 *
 * @author yuwb
 * @date 2018/9/17 16:10
 */
public class Use {
    public void use() {
        //引用对象的通常做法
        Object obj = new Object();
        //引用类型的使用示例
        SoftReference<Object> ref = new SoftReference<>(obj);
        obj = null;

        //使用引用类型的错误用法
        SoftReference<Object> reference = new SoftReference<>(new Object());
        //使用get方法的错误示例
        if (ref.get() != null) {
            Object objs = ref.get();
        }
    }

    /**
     * 引用队列的使用示例
     */
    void useSoftReference() {
        Object obj = new Object();
        ReferenceQueue queue = new ReferenceQueue();
        SoftReference<Object> ref = new SoftReference<>(obj, queue);
        obj = null;
    }
}
