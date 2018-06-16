package Java语言的动态性.脚本语言支持API.语言绑定;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 脚本引擎默认的语言绑定对象的示例
 */
public class UseDefaultBinding {
    private static void useDefaultBinding() throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        engine.put("name", "Alex");
        engine.eval("var message='hello, '+name;");
        engine.eval("print(message);");
        Object obj = engine.get("message");
        System.out.println(obj);
    }

    public static void main(String[] args) throws Exception {
        useDefaultBinding();
    }
}
