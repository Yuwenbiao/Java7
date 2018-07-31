package Java_IO.NIO_2.文件系统访问.监视目录变化;

import java.io.IOException;
import java.nio.file.*;

/**
 * 目录监视服务的使用示例
 *
 * @author yuwb
 * @date 18-7-31 上午8:39
 */
public class Calculate {
    public void calculate() throws IOException, InterruptedException {
        WatchService service = FileSystems.getDefault().newWatchService();
        Path path = Paths.get("").toAbsolutePath();
        path.register(service, StandardWatchEventKinds.ENTRY_CREATE);
        while (true) {
            WatchKey key = service.take();
            //当有事件发生时，通过pollEvents方法获取所有的事件
            for (WatchEvent<?> event : key.pollEvents()) {
                //获取事件的上下文信息
                Path createdPath = (Path) event.context();
                createdPath = path.resolve(createdPath);
                long size = Files.size(createdPath);
                System.out.println(createdPath + "==>" + size);
            }
            //重置
            key.reset();
        }
    }
}
