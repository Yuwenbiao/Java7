package Java7语法新特性.优化的异常处理;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 使用异常包装技术
 */
public class DataAccessGateway {
    public void load() throws DataAccessException {
        try {
            FileInputStream input = new FileInputStream("data.txt");
        } catch (IOException e) {
            throw new DataAccessException(e);
        }
    }
}