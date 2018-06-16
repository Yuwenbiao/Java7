package Java语言的动态性.脚本语言支持API.脚本执行上下文.自定义属性;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * 作用域影响同名属性查找的示例
 */
public class ScriptContextAttribute {
    private static void scriptContextAttribute() {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        ScriptContext context = engine.getContext();
        context.setAttribute("name", "Alex", ScriptContext.GLOBAL_SCOPE);
        context.setAttribute("name", "Bob", ScriptContext.ENGINE_SCOPE);
        System.out.println(context.getAttribute("name"));
    }

    public static void main(String[] args) {
        scriptContextAttribute();
    }
}
