package Java_IO.缓冲区.字节缓冲区;

import java.nio.ByteBuffer;

/**
 * 字节缓冲区的字节顺序
 */
public class ByteOrder {
    public void byteOrder() {
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.putInt(1);
        buffer.order(java.nio.ByteOrder.LITTLE_ENDIAN);
        buffer.getInt(0);//值为16777216
    }
}
