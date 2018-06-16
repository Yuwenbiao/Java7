package Java语言的动态性.脚本语言支持API.方法调用;

import javax.script.*;

/**
 * 在脚本中实现Java接口示例
 */
public class UseInterface {
    public static void main(String[] args) throws ScriptException {
        useInterface();
    }

    private static void useInterface() throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        String scriptText = "function getGreeting(name){return 'Hello '+name;};";

        engine.eval(scriptText);

        Invocable invocable = (Invocable) engine;
        Greet greet = invocable.getInterface(Greet.class);

        System.out.println(greet.getGreeting("Alex"));
    }

    public interface Greet {
        String getGreeting(String name);
    }
}
