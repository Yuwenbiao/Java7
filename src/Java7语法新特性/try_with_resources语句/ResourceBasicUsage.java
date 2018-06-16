package Java7语法新特性.try_with_resources语句;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 读取磁盘文件内容的示例
 */
public class ResourceBasicUsage {
    public String readFile(String path) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            StringBuilder builder = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append(String.format("%n"));
            }
            return builder.toString();
        }
    }
}
