package Java7其他重要更新.JavaBeans组件.持久化;

import java.beans.XMLEncoder;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

/**
 * XMLEncoder类的新的 构造方法的使用示例
 *
 * @author yuwb
 * @date 2018/9/17 15:42
 */
public class XMLEncoderUse {
    public void xmlEncoder() throws IOException {
        OutputStream output = Files.newOutputStream(Paths.get("result.xml"), StandardOpenOption.CREATE_NEW);
        try (XMLEncoder encoder = new XMLEncoder(output, StandardCharsets.UTF_8.name(), true, 0)) {
            encoder.writeObject(new MyBean());
        }
    }
}

class MyBean {

}
