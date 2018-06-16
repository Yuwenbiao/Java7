package Java语言的动态性.脚本语言支持API.语言绑定;

import javax.script.*;

/**
 * 自定义语言绑定对象的示例
 */
public class UseCustomBinding {
    private static void useCustomBinding() throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        Bindings bindings = new SimpleBindings();
        bindings.put("hobby", "playing games");
        engine.eval("print('I like '+hobby);", bindings);
    }

    public static void main(String[] args) throws Exception {
        useCustomBinding();
    }
}
