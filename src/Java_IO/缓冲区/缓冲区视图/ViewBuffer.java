package Java_IO.缓冲区.缓冲区视图;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * 字节缓冲区的视图
 */
public class ViewBuffer {
    public void viewBuffer() {
        ByteBuffer buffer = ByteBuffer.allocate(32);

        buffer.putInt(1);//读取位置为4
        IntBuffer intBuffer = buffer.asIntBuffer();
        intBuffer.put(2);
        int value = buffer.getInt();//值为2
    }

}
