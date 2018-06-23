package Java语言的动态性.动态语言支持.方法句柄.使用方法句柄实现接口;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandleProxies;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * 使用方法句柄实现接口的示例
 */
public class DoSomething {
    public void doSomething() {
        System.out.println("WORK");
    }

    public void useMethodHandleProxy() throws Throwable {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle mh = lookup.findVirtual(DoSomething.class, "doSomething", MethodType.methodType(void.class));
        mh = mh.bindTo(this);

        Runnable runnable = MethodHandleProxies.asInterfaceInstance(Runnable.class, mh);
        new Thread(runnable).start();
    }
}
