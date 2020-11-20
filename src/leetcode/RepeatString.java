package leetcode;

public class RepeatString {

    /**
     * 459. 重复的子字符串
     */


    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abcabc"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

}
