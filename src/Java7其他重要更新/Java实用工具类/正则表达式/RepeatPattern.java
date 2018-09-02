package Java7其他重要更新.Java实用工具类.正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 捕获分组的名称作为后向引用的示例
 *
 * @author yuwb
 * @date 18-9-2 下午5:07
 */
public class RepeatPattern {
    public void repeatPattern() {
        String str = "123-123-12-456-456";
        Pattern pattern=Pattern.compile("(?<num>\\d+)-\\k<num>");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            String repeat = matcher.group("num");
        }
    }
}
