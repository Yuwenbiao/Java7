package Java7语法新特性.优化的异常处理.处理异常;

/**
 * 异常消失的示例
 */
public class DisappearedException {
    public void show() throws BaseException {
        try {
            Integer.parseInt("Hello");
        } catch (NumberFormatException nfe) {
            throw new BaseException(nfe);
        } finally {
            try {
                int result = 2 / 0;
            } catch (ArithmeticException ae) {
                throw new BaseException(ae);
            }
        }
    }
}
