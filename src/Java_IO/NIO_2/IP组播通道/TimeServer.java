package Java_IO.NIO_2.IP组播通道;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Date;

/**
 * 进行组播的服务器端实现
 */
public class TimeServer {
    public void start() throws IOException {
        DatagramChannel dc = DatagramChannel.open(StandardProtocolFamily.INET).bind(null);
        InetAddress group = InetAddress.getByName("224.0.0.2");
        int port = 5000;
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                break;
            }

            String str = (new Date()).toString();
            dc.send(ByteBuffer.wrap(str.getBytes()), new InetSocketAddress(group, port));
        }
    }
}
