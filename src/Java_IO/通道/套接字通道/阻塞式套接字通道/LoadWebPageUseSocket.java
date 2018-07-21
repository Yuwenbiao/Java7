package Java_IO.通道.套接字通道.阻塞式套接字通道;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 阻塞式客户端套接字的使用示例
 */
public class LoadWebPageUseSocket {
    public static void loadWebPageUseSocket() throws IOException {
        try (FileChannel destChannel = FileChannel.open(Paths.get("content.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
             SocketChannel sc = SocketChannel.open(new InetSocketAddress("www.baidu.com", 80))) {
            String request = "GET/HTTP/1.1\r\n\r\nHost: wwww.baidu.com\r\n\n";
            ByteBuffer header = ByteBuffer.wrap(request.getBytes("UTF-8"));
            sc.write(header);
            destChannel.transferFrom(sc, 0, Integer.MAX_VALUE);
        }
    }

    public static void main(String[] args) throws IOException {
        loadWebPageUseSocket();
    }
}
