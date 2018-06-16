package Java语言的动态性.脚本语言支持API.方法调用;

import javax.script.*;

/**
 * 在Java中调用脚本中对象的成员方法的示例
 */
public class InvokeMethod {
    private static void invokeMethod() throws ScriptException, NoSuchMethodException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        String scriptText = "var obj={getGreeting: function(name){return 'Hello'+name;}};";

        engine.eval(scriptText);

        Invocable invocable = (Invocable) engine;
        Object scope = engine.get("obj");
        Object result = invocable.invokeMethod(scope, "getGreeting", "Alex");

        System.out.println(result);
    }

    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        invokeMethod();
    }
}
