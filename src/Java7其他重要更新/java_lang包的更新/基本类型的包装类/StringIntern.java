package Java7其他重要更新.java_lang包的更新.基本类型的包装类;

/**
 * 字符串内部化的示例
 */
public class StringIntern {
    public void stringIntern() {
        boolean value1 = "Hello" == "Hello";
        boolean value2 = (new String("Hello") == "Hello");
        boolean value3 = (new String("Hello").intern() == "Hello");
    }
}
