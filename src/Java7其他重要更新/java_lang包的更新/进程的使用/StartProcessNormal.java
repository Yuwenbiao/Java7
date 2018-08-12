package Java7其他重要更新.java_lang包的更新.进程的使用;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * 创建进程的示例
 */
public class StartProcessNormal {
    public void startProcessNormal() throws IOException {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "netstat", "-a");
        Process process = pb.start();
        InputStream input = process.getInputStream();
        Files.copy(input, Paths.get("netstat.txt"), StandardCopyOption.REPLACE_EXISTING);
    }
}
