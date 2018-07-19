package Java_IO.通道.文件通道.文件数据传输;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 使用字节缓冲区进行文件复制操作的示例
 */
public class CopyUseByteBuffer {
    public void copyUseByteBuffer() throws IOException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(32 * 1024);
        try (FileChannel src = FileChannel.open(Paths.get("src.txt"), StandardOpenOption.READ);
             FileChannel dest = FileChannel.open(Paths.get("dest.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            while (src.read(buffer) > 0 || buffer.position() != 0) {
                buffer.flip();
                dest.write(buffer);
                buffer.compact();
            }
        }
    }
}
