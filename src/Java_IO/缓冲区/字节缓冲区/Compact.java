package Java_IO.缓冲区.字节缓冲区;

import java.nio.ByteBuffer;

/**
 * 字节缓冲区的压缩操作的示例
 */
public class Compact {
    public void compact() {
        ByteBuffer buffer = ByteBuffer.allocate(32);

        buffer.put(new byte[16]);
        buffer.flip();
        buffer.getInt();//当前读取位置为4
        buffer.compact();
        int pos = buffer.position();//值为12
    }
}
