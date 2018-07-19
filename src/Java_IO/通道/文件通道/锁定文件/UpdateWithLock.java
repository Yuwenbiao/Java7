package Java_IO.通道.文件通道.锁定文件;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 锁定文件的示例
 */
public class UpdateWithLock {
    public void updateWithLock() throws IOException {
        try (FileChannel channel = FileChannel.open(Paths.get("settings.config"), StandardOpenOption.READ, StandardOpenOption.WRITE);
             FileLock lock = channel.lock()) {
            //更新文件内容
        }
    }
}
