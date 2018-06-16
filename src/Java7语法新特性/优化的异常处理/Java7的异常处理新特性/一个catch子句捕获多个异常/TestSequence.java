package Java7语法新特性.优化的异常处理.Java7的异常处理新特性.一个catch子句捕获多个异常;

/**
 * 声明异常的顺序的正确示例
 */
public class TestSequence {
    /**
     * catch子句中声明异常的顺序的正确示例
     * 注意：有误
     * Java 8 中已经改正
     */
//    public void testSequence() {
//        try {
//            Integer.parseInt("Hello");
//        } catch (NumberFormatException | RuntimeException e) {
//
//        }
//    }

    /**
     *  catch子句中声明异常的顺序的错误示例
     */
//    public void testSequenceError() {
//        try {
//            Integer.parseInt("Hello");
//        } catch (RuntimeException | NumberFormatException e) {
//
//        }
//    }

    /**
     * 异常捕获的等价形式
     */
//    public void testSequenceError() {
//        try {
//            Integer.parseInt("Hello");
//        } catch (RuntimeException e) {
//
//        } catch (NumberFormatException e) {
//
//        }
//    }

    /**
     * catch子句中异常参数的具体类型
     */
    public void testCatchType() {
//        try {
//            throwException();
//        } catch (ExceptionASub1 | ExceptionASub2 e) {
//            e.methodInExceptionA();
//        }
    }
}
