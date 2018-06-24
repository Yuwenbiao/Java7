package Java_IO.流.输入流的复用;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 使用BufferedInputStream类进行流复用的示例
 */
public class StreamReuse {
    private InputStream input;

    public StreamReuse(InputStream input) {
        if (!input.markSupported()) {
            this.input = new BufferedInputStream(input);
        } else {
            this.input = input;
        }
    }

    private InputStream getInputStream() {
        input.mark(Integer.MAX_VALUE);
        return input;
    }

    private void markUsed() throws IOException {
        input.reset();
    }
}