package Java_IO.通道.套接字通道.多路复用套接字通道;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * 选择器的使用示例
 */
public class LoadWebPageUseSelector {
    public void load(Set<URL> urls) throws IOException {
        Map<SocketAddress, String> mapping = urlTtoSocketAddress(urls);
        //创建选择器
        Selector selector = Selector.open();

        //注册到Selector
        for (SocketAddress address : mapping.keySet()) {
            register(selector, address);
        }

        int finished = 0, total = mapping.size();
        ByteBuffer buffer = ByteBuffer.allocate(32 * 1024);
        int len = -1;

        while (finished < total) {
            //进行通道选择操作，直接调用select方法是会阻塞的，直到所监听的套接字通道至少有一个它们所感兴趣的的事件发生为止
            selector.select();
            //获取到表示被选中的通道的SelectionKey类的对象的集合
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();

                //
                if (key.isValid() && key.isReadable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    InetSocketAddress address = (InetSocketAddress) channel.getRemoteAddress();
                    String filename = address.getHostName() + ".txt";

                    FileChannel destChannel = FileChannel.open(Paths.get(filename), StandardOpenOption.APPEND, StandardOpenOption.CREATE);
                    buffer.clear();

                    while ((len = channel.read(buffer)) > 0 || buffer.position() != 0) {
                        buffer.flip();
                        destChannel.write(buffer);
                        buffer.compact();
                    }

                    if (len == -1) {
                        finished++;
                        key.cancel();
                    }
                } else if (key.isValid() && key.isConnectable()) {
                    SocketChannel channel = (SocketChannel) key.channel();
                    boolean success = channel.finishConnect();

                    if (!success) {
                        finished++;
                        key.cancel();
                    } else {
                        InetSocketAddress address = (InetSocketAddress) channel.getRemoteAddress();
                        String path = mapping.get(address);
                        String request = "GET" + path + "HTTP/1.0\r\n\r\nHost:" + address.getHostString() + "\r\n\r\n";
                        ByteBuffer header = ByteBuffer.wrap(request.getBytes("UTF-8"));
                        channel.write(header);
                    }
                }
            }
        }
    }

    private Map<SocketAddress, String> urlTtoSocketAddress(Set<URL> urls) {
        Map<SocketAddress, String> mapping = new HashMap<>();

        for (URL url : urls) {
            int port = url.getPort() != -1 ? url.getPort() : url.getDefaultPort();
            SocketAddress address = new InetSocketAddress(url.getHost(), port);
            String path = url.getPath();
            if (url.getQuery() != null) {
                path = path + "?" + url.getQuery();
            }
            mapping.put(address, path);
        }
        return mapping;
    }

    /**
     * 把套接字通道注册到选择器上
     * @param selector
     * @param address
     * @throws IOException
     */
    private void register(Selector selector, SocketAddress address) throws IOException {
        //创建连接HTTP服务器的套接字通道
        SocketChannel channel = SocketChannel.open();
        //将通道设置成非阻塞模式
        channel.configureBlocking(false);
        //连接HTTP服务器
        channel.connect(address);
        //注册到选择器上，并指定感兴趣的事件，即连接完成和通道有数据可读
        channel.register(selector, SelectionKey.OP_CONNECT | SelectionKey.OP_READ);
    }
}
