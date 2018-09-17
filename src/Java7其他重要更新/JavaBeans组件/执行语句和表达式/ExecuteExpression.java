package Java7其他重要更新.JavaBeans组件.执行语句和表达式;

import java.beans.Expression;

/**
 * Expression类的使用示例
 *
 * @author yuwb
 * @date 2018/9/17 15:10
 */
public class ExecuteExpression {
    public void executeExpression() throws Exception {
        Expression expr = new Expression(new MyObject(), "greet", new Object[]{"alex"});
        expr.execute();
        Object result = expr.getValue();
        System.out.println(result);
    }
}

class MyObject {
    public String greet(String name) {
        return "hello";
    }
}
