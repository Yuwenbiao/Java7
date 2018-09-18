package Java虚拟机.引用类型.软引用;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * 使用软引用的文件编辑器
 *
 * @author yuwb
 * @date 2018/9/18 10:07
 */
public class FileEditor {
    private static class FileData {
        private Path filePath;
        private SoftReference<byte[]> dataRef;

        public FileData(Path filePath) {
            this.filePath = filePath;
            this.dataRef = new SoftReference<>(new byte[0]);
        }

        public Path getPath() {
            return filePath;
        }

        public byte[] getData() throws IOException {
            byte[] dataArray = dataRef.get();
            if (dataArray == null || dataArray.length == 0) {
                dataArray = readFile();
                dataRef = new SoftReference<>(dataArray);
                dataArray = null;
            }
            return dataRef.get();
        }

        private byte[] readFile() throws IOException {
            return Files.readAllBytes(filePath);
        }
    }

    private FileData currentFileData;
    private Map<Path, FileData> openedFiles = new HashMap<>();

    public void switchTo(String filePath) {
        Path path = Paths.get(filePath).toAbsolutePath();
        if (openedFiles.containsKey(path)) {
            currentFileData = openedFiles.get(path);
        } else {
            currentFileData = new FileData(path);
            openedFiles.put(path, currentFileData);
        }
    }

    public void useFile() throws IOException {
        if (currentFileData != null) {
            System.out.println(String.format("当前文件%1$s的大小为$2$d", currentFileData.getPath(), currentFileData.getData().length));
        }
    }
}
