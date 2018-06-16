package Java7语法新特性.try_with_resources语句;

/**
 * 自定义资源使用AutoCloseable接口示例
 */
public class CustomResource implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("进行资源释放。");
    }

    public void useCustomResource() throws Exception {
        try (CustomResource resource = new CustomResource()) {
            System.out.println("使用资源");
        }
    }
}
