package Java_IO.NIO_2.文件系统访问.文件目录列表流;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author yuwb
 * @date 18-7-30 上午11:46
 */
public class ListFiles {
    public void listFiles() throws IOException {
        Path path = Paths.get("");
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path, "*.java")) {
            for (Path entry : stream) {
                //使用entry
            }
        }
    }
}
