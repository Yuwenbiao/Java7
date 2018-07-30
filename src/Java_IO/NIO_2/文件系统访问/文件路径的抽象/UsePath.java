package Java_IO.NIO_2.文件系统访问.文件路径的抽象;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author yuwb
 * @date 18-7-30 上午11:31
 */
public class UsePath {
    public void usePath() {
        Path path1 = Paths.get("folder1", "sub1");
        Path path2 = Paths.get("folder2", "sub2");
        //folder1\sub1\folder2\sub2
        path1.resolve(path2);
        //folder1\folder2\sub2
        path1.resolveSibling(path2);
        //..\..\folder2\sub2
        path1.relativize(path2);
        //folder1
        path1.subpath(0, 1);
        //false
        path1.startsWith(path2);
        //false
        path1.endsWith(path2);
        //folder2\my.text
        Paths.get("folder1/./../folder2/my.text").normalize();
    }
}
