package Java_IO.通道.内存映射文件;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 内存映射文件的使用示例
 */
public class MapFile {
    public void mapFile() throws IOException {
        try (FileChannel channel = FileChannel.open(Paths.get("src.data"), StandardOpenOption.READ, StandardOpenOption.WRITE)) {
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, channel.size());
            byte b = buffer.get(1024 * 1024);
            buffer.put(5 * 1024 * 1024, b);
            buffer.force();
        }
    }
}
