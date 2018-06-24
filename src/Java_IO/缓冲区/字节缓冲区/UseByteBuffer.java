package Java_IO.缓冲区.字节缓冲区;

import java.nio.ByteBuffer;

/**
 * ByteBuffer类的使用示例
 */
public class UseByteBuffer {
    public void useByteBuffer() {
        ByteBuffer buffer = ByteBuffer.allocate(32);
        buffer.put((byte) 1);
        buffer.put(new byte[3]);
        buffer.putChar('A');
        buffer.putFloat(0.0f);
        buffer.putLong(10, 100L);
        buffer.getChar(4);//值为‘A’
    }
}
