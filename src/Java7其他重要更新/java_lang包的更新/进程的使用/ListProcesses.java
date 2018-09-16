package Java7其他重要更新.java_lang包的更新.进程的使用;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * 进程的输入和输出的文件式处理方式的示例
 */
public class ListProcesses {
    public void listProcesses() throws IOException {
        ProcessBuilder pb = new ProcessBuilder("wmic", "process");
        File output = Paths.get("tasks.txt").toFile();
        pb.redirectOutput(output);
        pb.start();
    }
}
