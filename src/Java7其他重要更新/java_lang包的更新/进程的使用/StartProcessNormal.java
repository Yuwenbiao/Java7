package Java7其他重要更新.java_lang包的更新.进程的使用;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * 进程的使用
 */
public class StartProcessNormal {
    /**
     * 创建进程的示例
     */
    public void startProcessNormal() throws IOException {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "netstat", "-a");
        Process process = pb.start();
        InputStream input = process.getInputStream();
        Files.copy(input, Paths.get("netstat.txt"), StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * 进程的输入和输出的继承式处理方式的示例
     */
    public void dir() throws IOException {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "dir");
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        pb.start();
    }

    /**
     * 进程的输入和输出的文件式处理方式的示例
     */
    public void listProcess() throws IOException {
        ProcessBuilder pb = new ProcessBuilder("wmic", "process");
        File output = Paths.get("tasks.txt").toFile();
        pb.redirectOutput(output);
        pb.start();
    }
}
