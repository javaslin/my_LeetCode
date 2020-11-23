package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {


    static HashMap<String, String> map = new HashMap<String, String>() {
        {
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }
    };
    static List<String> ans = new ArrayList<>();

    static void dfs(String digits, int u, String path) {
        if (u == digits.length()) {
            ans.add(path);
            return;
        }
        String t = map.get(digits.substring(u, u + 1));
        for (int i = 0; i < t.length(); i++) {
            dfs(digits, u + 1, path + t.charAt(i));
        }
    }

    public List<String> letterCombinations(String digits) {
        ans.clear();
        int n = digits.length();
        if (n == 0) return ans;
        dfs(digits, 0, "");
        return ans;
    }
}
