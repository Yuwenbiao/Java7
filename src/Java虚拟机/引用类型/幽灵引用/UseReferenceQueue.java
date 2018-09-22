package Java虚拟机.引用类型.幽灵引用;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * 幽灵引用对象的使用示例
 *
 * @author yuwb
 * @date 2018/9/21 13:41
 */
public class UseReferenceQueue {
    private static class ReferencedObject{
        @Override
        protected void finalize() throws Throwable {
            System.out.println("finalize方法被调用");
            super.finalize();
        }
    }

    public void phantomReferenceQueue() {
        ReferenceQueue<ReferencedObject> queue = new ReferenceQueue<>();
        ReferencedObject obj = new ReferencedObject();
        PhantomReference<ReferencedObject> phantomRef = new PhantomReference<>(obj, queue);
        obj = null;
        Reference<? extends ReferencedObject> ref=null;
        while ((ref = queue.poll()) == null) {
            System.gc();
        }
        phantomRef.clear();
        //值为true
        System.out.println(ref == phantomRef);
        System.out.println("幽灵引用被清除");
    }
}
