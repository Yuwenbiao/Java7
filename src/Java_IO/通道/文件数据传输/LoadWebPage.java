package Java_IO.通道.文件数据传输;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 使用文件通道保存网页内容的示例
 */
public class LoadWebPage {
    public void loadWebPage(String url) throws IOException {
        try (FileChannel destChannel = FileChannel.open(Paths.get("content.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
            InputStream input = new URL(url).openStream();
            ReadableByteChannel srcChannel = Channels.newChannel(input);
            destChannel.transferFrom(srcChannel, 0, Integer.MAX_VALUE);
        }
    }
}
