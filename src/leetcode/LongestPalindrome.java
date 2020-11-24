package leetcode;


import java.util.Arrays;

public class LongestPalindrome {
    //遍历字符串所有字符 从每个字符开始向两边扩展 是否是回文串
    //注意处理奇偶两种模式：
    //1. aba
    //2. abba
    //O(n*n)
    public static String longestPalindrome(String s) {

        int maxLength = 0;

        String res = "";

        for (int i = 0; i < s.length(); i++) {

            //j=1 向两边扩展一个单位 j=2 向两边扩展两个单位
            for (int j = 0; i - j >= 0 && i + j < s.length(); j++) {
                if (s.charAt(i - j) == s.charAt(i + j)) {
                    if (j * 2 + 1 > maxLength) {
                        maxLength = j * 2 + 1;
                        res = s.substring(i - j, i + j + 1);
                    }
                } else break;
            }


            for (int j = i, k = i + 1; j >= 0 && k < s.length(); j--, k++) {
                if (s.charAt(j) == s.charAt(k)) {
                    if (k - j + 1 > maxLength) {
                        maxLength = k - j + 1;
                        res = s.substring(j, k + 1);
                    }
                } else break;
            }

        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("cbbd"));

        System.out.println("cbbd".substring(1, 3));
    }


}
