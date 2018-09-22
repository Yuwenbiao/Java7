package Java虚拟机.引用类型.幽灵引用;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * 使用幽灵引用的内存分配方式
 *
 * @author yuwb
 * @date 18-9-22 下午10:05
 */
public class PhantomAllocator {
    private byte[] data = null;
    private ReferenceQueue<byte[]> queue = new ReferenceQueue<>();
    private Reference<? extends byte[]> ref = null;

    public byte[] get(int size) {
        if (ref == null) {
            data = new byte[size];
            ref = new PhantomReference<>(data, queue);
        } else {
            data = null;
            System.gc();
            try {
                ref = queue.remove();
                ref.clear();
                ref = null;
                System.gc();
                data = new byte[size];
                ref = new PhantomReference<>(data, queue);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return data;
    }
}
