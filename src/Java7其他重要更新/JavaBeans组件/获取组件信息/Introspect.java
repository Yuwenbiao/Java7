package Java7其他重要更新.JavaBeans组件.获取组件信息;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;

/**
 * getBeanInfo方法的使用示例
 *
 * @author yuwb
 * @date 2018/9/16 22:23
 */
public class Introspect {
    public void introspect() throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(MyBean.class, ParentBean.class, Introspector.IGNORE_ALL_BEANINFO);
        outBeanInfo(beanInfo);
    }

    private void outBeanInfo(BeanInfo beanInfo) {

    }
}

class MyBean extends ParentBean {

}

class ParentBean {

}
