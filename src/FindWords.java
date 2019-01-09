import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
给定一个单词列表，只返回可以使用在键盘同一行的字母打印出来的单词
示例：

输入: ["Hello", "Alaska", "Dad", "Peace"]
输出: ["Alaska", "Dad"]
 */
public class FindWords {
    public String[] findWords(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        String s1 = "qwertyuiop";
        String s2 = "asdfghkjl";
        String s3 = "zxcvbnm";
        List<String> list = new ArrayList<>();

        for (char c : s1.toCharArray()) {
            map.put(c, 1);
        }
        for (char c : s2.toCharArray()) {
            map.put(c, 2);
        }
        for (char c : s3.toCharArray()) {
            map.put(c, 3);
        }

        for (String word : words) {
            int num = map.get(word.toLowerCase().charAt(0));
            for (int i = 0; i < word.length(); i++) {
                if (num != map.get(word.toLowerCase().charAt(i))) {
                    break;
                }
                if (i == (word.length() - 1)) {
                    list.add(word);
                }
            }
        }
        return list.toArray(new String[0]);
    }
}
