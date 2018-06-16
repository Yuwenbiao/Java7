package Java语言的动态性.脚本语言支持API.脚本执行上下文.自定义属性;

import javax.script.*;

/**
 * 通过脚本执行上下文获取语言绑定对象的示例
 */
public class UseScriptContextValues {
    public static void main(String[] args) throws ScriptException {
        useScriptContextValues();
    }

    private static void useScriptContextValues() throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        ScriptContext context = engine.getContext();
        Bindings bindings = context.getBindings(ScriptContext.ENGINE_SCOPE);

        bindings.put("name", "Alex");
        engine.eval("print(name);");
    }
}