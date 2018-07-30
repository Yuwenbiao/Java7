package Java_IO.NIO_2.文件系统访问.文件属性;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;

/**
 * @author yuwb
 * @date 18-7-30 下午3:41
 */
public class UseFileAttributeView {
    /**
     * 文件视图的使用示例
     *
     * @throws IOException
     */
    public void useFileAttributeView() throws IOException {
        Path path = Paths.get("content.txt");
        DosFileAttributeView view = Files.getFileAttributeView(path, DosFileAttributeView.class);
        if (view != null) {
            DosFileAttributes attrs = view.readAttributes();
            System.out.println(attrs.isReadOnly());
        }
    }

    /**
     * 获取文件的上次修改时间的示例
     *
     * @param path
     * @param intervalInMillis
     * @return
     */
    public boolean checkUpdatesRequired(Path path, int intervalInMillis) throws IOException {
        FileTime lastModifiedTime = (FileTime) Files.getAttribute(path, "lastModified");
        long now = System.currentTimeMillis();
        return now - lastModifiedTime.toMillis() > intervalInMillis;
    }
}
