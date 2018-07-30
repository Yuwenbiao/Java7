package Java_IO.NIO_2.文件系统访问.文件目录树遍历;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * 删除Subversion元数据的目录遍历方式
 *
 * @author yuwb
 * @date 18-7-30 上午11:56
 */
public class SvnInfoCleanVisitor extends SimpleFileVisitor<Path> {
    private boolean cleanMark = false;

    private boolean isSvnFolder(Path dir) {
        return ".svn".equals(dir.getFileName().toString());
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        if (isSvnFolder(dir)) {
            cleanMark = true;
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        if (exc == null && cleanMark) {
            Files.delete(dir);
            if (isSvnFolder(dir)) {
                cleanMark = false;
            }
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if (cleanMark) {
            Files.setAttribute(file, "dos: readonly", false);
            Files.delete(file);
        }
        return FileVisitResult.CONTINUE;
    }
}
