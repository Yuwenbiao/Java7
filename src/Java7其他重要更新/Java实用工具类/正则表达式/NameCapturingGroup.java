package Java7其他重要更新.Java实用工具类.正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 通过命名捕获分组来匹配字符串并提取内容的示例
 *
 * @author yuwb
 * @date 18-9-2 下午4:53
 */
public class NameCapturingGroup {

    public void namedCapturingGroup() {
        String url = "http://www.example.org/uid/alex/docid/1/title/MyFirstBlog";
        String patternStr = "^.*/uid/(?<uid>.*)/docid/(?<docid>.*)/title/(?<title>.*)";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(url);
        if (matcher.matches()) {
            //值为alex
            String uid = matcher.group("uid");
            //值为1
            String docId = matcher.group("docid");
            //值为MyFirstBlog
            String title = matcher.group("title");
        }
    }
}
