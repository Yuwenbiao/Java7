package Java_IO.NIO_2.异步IO通道;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AsyncWrite {
    /**
     * 向异步文件通道中写入数据的示例
     */
    public void asyncWrite() throws IOException, ExecutionException, InterruptedException {
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(Paths.get("large.bin"), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        ByteBuffer buffer = ByteBuffer.allocate(32 * 1024 * 1024);
        Future<Integer> result = channel.write(buffer, 0);

        //其他操作
        Integer len = result.get();
    }
}
