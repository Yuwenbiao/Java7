package Java语言的动态性.脚本语言支持API.脚本执行上下文.语言绑定对象;

import javax.script.*;

/**
 * 语言绑定对象的优先级顺序示例
 */
public class ScriptContextBindings {
    private static void scriptContextBindings() throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        ScriptContext context = engine.getContext();

        Bindings bindings1 = engine.createBindings();
        bindings1.put("name", "Alex");
        context.setBindings(bindings1, ScriptContext.GLOBAL_SCOPE);

        Bindings bindings2 = engine.createBindings();
        bindings2.put("name", "Bob");
        context.setBindings(bindings2, ScriptContext.ENGINE_SCOPE);

        engine.eval("print(name);");
    }

    public static void main(String[] args) throws Exception {
        scriptContextBindings();
    }
}
