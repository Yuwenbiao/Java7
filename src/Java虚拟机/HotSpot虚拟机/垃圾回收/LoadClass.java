package Java虚拟机.HotSpot虚拟机.垃圾回收;

import jdk.internal.org.objectweb.asm.ClassWriter;

/**
 * 由于加载的java类过多造成内存不足的示例
 *
 * @author yuwb@corp.21cn.com
 * @date 2018/10/4 19:11
 */
public class LoadClass extends ClassLoader {
    private void loadManyClasses() {
        int num = 50000;
        String classNamePrefix = "ManyClass";
        for (int i = 0; i < num; i++) {
            String className = classNamePrefix + i;
            createAndLoadClass(className);
        }
    }

    private void createAndLoadClass(String className) {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        cw.visit(1, 2, className, null, "java/lang/Object", null);
        cw.visitEnd();
        byte[] classData = cw.toByteArray();
        this.defineClass(className, classData, 0, classData.length);
    }
}
