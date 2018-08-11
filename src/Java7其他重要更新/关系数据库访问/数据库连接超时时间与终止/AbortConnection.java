package Java7其他重要更新.关系数据库访问.数据库连接超时时间与终止;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * abort方法的使用示例
 */
public class AbortConnection {
    public void abortConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:derby://localhost/java7book");
        ThreadPoolExecutor executor = new DebugExecutorService(2, 10, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
        connection.abort(executor);
        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class DebugExecutorService extends ThreadPoolExecutor {
        public DebugExecutorService(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        }

        public void beforeExecute(Thread t, Runnable r) {
            System.out.println("清理任务：" + r.getClass());
            super.beforeExecute(t, r);
        }
    }
}
