package Java语言的动态性.动态语言支持.方法句柄.交换点;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.invoke.SwitchPoint;

/**
 * 交换点的使用示例
 */
public class UseSwitchPoint {
    public void useSwitchPoint() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        MethodType type = MethodType.methodType(int.class, int.class, int.class);
        MethodHandle mhMax = lookup.findStatic(Math.class, "max", type);
        MethodHandle mhMin = lookup.findStatic(Math.class, "min", type);

        SwitchPoint sp = new SwitchPoint();
        MethodHandle mhNew = sp.guardWithTest(mhMin, mhMax);

        mhNew.invoke(3, 4);//值为3
        SwitchPoint.invalidateAll(new SwitchPoint[]{sp});
        mhNew.invoke(3, 4);//值为4
    }
}
