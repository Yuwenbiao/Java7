package Java语言的动态性.脚本语言支持API.脚本的编译;

import javax.script.*;

/**
 * 进行脚本编译的示例
 */
public class Compile {
    private static CompiledScript compile(String scriptText) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        if (engine instanceof Compilable) {
            CompiledScript script = ((Compilable) engine).compile(scriptText);
            return script;
        }
        return null;
    }

    private static void run(String scriptText) throws ScriptException {
        CompiledScript script = compile(scriptText);
        if (script == null) {
            return;
        }
        for (int i = 0; i < 100; i++) {
            script.eval();
        }
    }
}
