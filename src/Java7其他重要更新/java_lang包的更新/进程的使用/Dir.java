package Java7其他重要更新.java_lang包的更新.进程的使用;

import java.io.IOException;

/**
 * 进程的输入和输出的继承式处理方式的示例
 */
public class Dir {
    public void dir() throws IOException {
        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "dir");
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        pb.start();
    }
}
