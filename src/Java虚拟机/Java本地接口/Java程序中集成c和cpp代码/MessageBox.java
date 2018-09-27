package Java虚拟机.Java本地接口.Java程序中集成c和cpp代码;

/**
 * 消息提示Java类的基本声明
 *
 * @author yuwb
 * @date 18-9-27 下午9:47
 */
public class MessageBox {
    static {
        System.loadLibrary("MessageBox");
    }

    public native int show(String text, String caption);
}
