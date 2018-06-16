package Java语言的动态性.脚本语言支持API.脚本引擎;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 脚本引擎的一般用法
 */
public class GeneralInstructions {
    public static void greet() throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        if (engine == null) {
            throw new RuntimeException("找不到js执行引擎");
        }

        engine.eval("print('Hello!');");
    }

    public static void main(String[] args) {
        try {
            greet();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
