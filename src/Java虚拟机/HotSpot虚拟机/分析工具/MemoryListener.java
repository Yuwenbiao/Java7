package Java虚拟机.HotSpot虚拟机.分析工具;

import javax.management.Notification;
import javax.management.NotificationEmitter;
import javax.management.NotificationListener;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryNotificationInfo;

/**
 * 使用事件监听机制的内存监控示例
 *
 * @author yuwb@corp.21cn.com
 * @date 2018/10/4 19:23
 */
public class MemoryListener implements NotificationListener {
    @Override
    public void handleNotification(Notification notification, Object handback) {
        String type = notification.getType();
        if (type.equals(MemoryNotificationInfo.MEMORY_COLLECTION_THRESHOLD_EXCEEDED)) {
            System.out.println("内存占用量超过阀值");
        }
    }

    public void addListener() {
        MemoryMXBean mbean = ManagementFactory.getMemoryMXBean();
        NotificationEmitter emitter = (NotificationEmitter) mbean;
        MemoryListener listener = new MemoryListener();
        emitter.addNotificationListener(listener, null, null);
    }
}
