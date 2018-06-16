package Java语言的动态性.脚本语言支持API.脚本执行上下文.输入与输出;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 把脚本运行时的输出写入到文件中的示例
 */
public class ScriptToFile {
    private static void scriptToFile() throws IOException, ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        ScriptContext context = engine.getContext();
        context.setWriter(new FileWriter("output.txt"));
        engine.eval("print('hello world');");
    }

    public static void main(String[] args) throws Exception {
        scriptToFile();
    }
}
