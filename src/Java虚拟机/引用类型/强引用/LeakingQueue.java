package Java虚拟机.引用类型.强引用;

import java.util.ArrayList;
import java.util.List;

/**
 * 产生内存泄漏的先进先出队列的实现
 *
 * @author yuwb
 * @date 2018/9/17 15:56
 */
public class LeakingQueue<T> {
    private List<T> backendList = new ArrayList<>();
    private int topIndex = 0;

    public void enqueue(T value) {
        backendList.add(value);
    }

    public T dequeue() {
        //这个队列实现的问题在于没有把对象从队列中删除
        T result = backendList.get(topIndex);
        topIndex++;
        return result;
    }
}
