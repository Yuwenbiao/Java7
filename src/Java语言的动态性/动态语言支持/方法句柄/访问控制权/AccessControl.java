package Java语言的动态性.动态语言支持.方法句柄.访问控制权;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * 方法句柄查找时的访问控制权限
 */
public class AccessControl {
    private void privateMethod() {
        System.out.println("PRIVATE");
    }

    public MethodHandle accessControl() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();

        MethodHandle mh = lookup.findSpecial(AccessControl.class, "privateMethod", MethodType.methodType(void.class), AccessControl.class);
        mh = mh.bindTo(this);
        return mh;
    }
}
