package Java7其他重要更新.Java实用工具类.正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * UNICODE_CHARACTER_CLASS标记的使用示例
 *
 * @author yuwb
 * @date 18-9-3 下午1:42
 */
public class UseUnicodeCharacterClass {
    public void useUnicodeCharacterClass() {
        String str = "100 100";
        Pattern pattern=Pattern.compile("(\\d+)");
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            //值为100
            String digit=matcher.group(1);
        }

        pattern = Pattern.compile("(\\d+ )", Pattern.UNICODE_CHARACTER_CLASS);
        matcher = pattern.matcher(str);
        if (matcher.find()) {
            //值为100 100
            String digit=matcher.group(1);
        }
    }
}
