package Java语言的动态性.反射API.操作数组;

import java.lang.reflect.Array;

/**
 * 使用反射API操作数组
 */
public class ArrayReflect {
    public void useArray() {
        String[] names = (String[]) Array.newInstance(String.class, 10);
        names[0] = "Hello";
        Array.set(names, 1, "world");
        String str = (String) Array.get(names, 0);

        int[][][] matrix1 = (int[][][]) Array.newInstance(int.class, 3, 3, 3);
        matrix1[0][0][0] = 1;

        int[][][] matrix2 = (int[][][]) Array.newInstance(int[].class, 3, 4);
        matrix2[0][0] = new int[10];
        matrix2[0][1] = new int[3];
        matrix2[0][0][1] = 1;
    }
}
