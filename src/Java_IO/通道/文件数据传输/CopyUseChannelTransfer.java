package Java_IO.通道.文件数据传输;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 使用文件通道进行文件复制的示例
 */
public class CopyUseChannelTransfer {
    public void copyUseChannelTransfer() throws IOException {
        try (FileChannel src = FileChannel.open(Paths.get("src.txt"), StandardOpenOption.READ);
             FileChannel dest = FileChannel.open(Paths.get("dest.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            src.transferTo(0, src.size(), dest);
        }
    }
}
