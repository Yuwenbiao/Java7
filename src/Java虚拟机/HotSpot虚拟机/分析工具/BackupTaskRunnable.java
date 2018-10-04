package Java虚拟机.HotSpot虚拟机.分析工具;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.util.List;

/**
 * 考虑内存剩余量的备份任务的示例
 *
 * @author yuwb@corp.21cn.com
 * @date 2018/10/4 19:18
 */
public class BackupTaskRunnable implements Runnable {
    private MemoryPoolMXBean poolMXBean;

    public BackupTaskRunnable() {
        init();
    }

    private void init() {
        List<MemoryPoolMXBean> beans = ManagementFactory.getMemoryPoolMXBeans();
        for (MemoryPoolMXBean bean : beans) {
            if ("Tenured Gen".equals(bean.getName())) {
                poolMXBean = bean;
                break;
            }
        }
        poolMXBean.setUsageThreshold(10 * 1024 * 1024);
    }

    @Override
    public void run() {
        while (true) {
            if (poolMXBean.isUsageThresholdExceeded()) {
                System.out.println("内存不足，暂停备份任务");
            } else {
                System.out.println("执行备份任务");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
