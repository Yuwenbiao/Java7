package Java7语法新特性.优化的异常处理.处理异常;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 使用addSuppressed方法记录异常的示例
 */
public class ReadFile2 {
    public void read(String filename) throws BaseException {
        FileInputStream input = null;
        IOException readException = null;
        try {
            input = new FileInputStream(filename);
        } catch (IOException e) {
            readException = e;
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    if (readException != null) {
                        readException.addSuppressed(e);
                    } else {
                        readException = e;
                    }
                }
            }
            if (readException != null) {
                throw new BaseException(readException);
            }
        }
    }
}
