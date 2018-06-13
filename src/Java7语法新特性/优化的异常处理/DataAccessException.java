package Java7语法新特性.优化的异常处理;

public class DataAccessException extends Throwable {
    public DataAccessException(Throwable cause) {
        super(cause);
    }
}
