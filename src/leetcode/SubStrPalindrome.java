package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SubStrPalindrome {

    static List<List<String>> ans = new ArrayList<>();
    static List<String> path = new ArrayList<>();


    public static boolean isPalindrome(String s) {
        if (s.length() == 0) return false;

        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }


    public static void dfs(int u, String subStr, String oStr) {
        if (u == oStr.length()) {
            if (isPalindrome(subStr)) {
                path.add(subStr);
                List<String> copy = new ArrayList<>();
                copy.addAll(path);
                ans.add(copy);
                path.remove(path.size() - 1);
            }
            return;
        }

        if (isPalindrome(subStr)) {
            path.add(subStr);
            dfs(u, "", oStr);
            path.remove(path.size() - 1);
        }

        dfs(u + 1, subStr + oStr.charAt(u), oStr);
    }

    public List<List<String>> partition(String s) {

        ans.clear();

        dfs(0, "", s);
        return ans;


    }

    public static void main(String[] args) {

        String str = "aab";
        dfs(0, "", str);

        System.out.println(ans.size());


    }

}
