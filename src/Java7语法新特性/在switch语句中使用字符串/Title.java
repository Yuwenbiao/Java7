package Java7语法新特性.在switch语句中使用字符串;

/**
 * 在switch语句中使用字符串的示例
 */
public class Title {
    public String generate(String name, String gender) {
        String title = "";
        switch (gender) {
            case "男":
                title = name + "先生";
                break;
            case "女":
                title = name + "女士";
                break;
            default:
                title = name;
        }
        return title;
    }
}
