package Java语言的动态性.脚本语言支持API.方法调用;

import javax.script.*;

/**
 * 在Java中调用脚本中顶层方法的示例
 */
public class InvokeFunction {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        invokeFunction();
    }

    private static void invokeFunction() throws ScriptException, NoSuchMethodException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        String scriptText = "function greet(name) {print(name);}";

        engine.eval(scriptText);

        Invocable invocable = (Invocable) engine;
        invocable.invokeFunction("greet", "Alex");
    }
}
