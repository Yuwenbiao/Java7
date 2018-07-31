package Java_IO.NIO_2.zip_jar文件系统;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

/**
 * 基于zip/jar文件系统实现的添加新文件到已有zip文件的做法
 *
 * @author yuwb
 * @date 18-7-31 上午11:52
 */
public class AddFileToZip2 {
    public void addFileToZip2(File zipFile,File fileToAdd) throws IOException {
        Map<String, String> env = new HashMap<>();
        env.put("create", "true");
        try (FileSystem fs = FileSystems.newFileSystem(URI.create("jar:" + zipFile.toURI()), env)) {
            Path pathToAddFile = fileToAdd.toPath();
            Path pathInZipfile = fs.getPath("/" + fileToAdd.getName());
            Files.copy(pathToAddFile, pathInZipfile, StandardCopyOption.REPLACE_EXISTING);
        }
    }
}
