package Java_IO.通道.套接字通道.阻塞式套接字通道;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 阻塞式服务器端套接字的使用示例
 */
public class StartSimpleServer {
    public void startSimpleServer() throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        channel.bind(new InetSocketAddress("localhost", 10800));
        while (true) {
            try (SocketChannel sc = channel.accept()) {
                sc.write(ByteBuffer.wrap("Hello".getBytes("UTF-8")));
            }
        }
    }
}
