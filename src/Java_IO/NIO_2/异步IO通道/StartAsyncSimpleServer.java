package Java_IO.NIO_2.异步IO通道;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.Executors;

/**
 * 异步套接字通道的使用示例
 */
public class StartAsyncSimpleServer {
    public void startAsyncSimpleServer() throws IOException {
        AsynchronousChannelGroup group = AsynchronousChannelGroup.withFixedThreadPool(10, Executors.defaultThreadFactory());
        final AsynchronousServerSocketChannel serverSocketChannel = AsynchronousServerSocketChannel.open(group).bind(new InetSocketAddress(10080));
        serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {
            @Override
            public void completed(AsynchronousSocketChannel result, Void attachment) {
                serverSocketChannel.accept(null, this);
                //使用clientChannel
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                //错误处理
            }
        });
    }
}
