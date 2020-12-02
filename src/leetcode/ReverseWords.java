package leetcode;

public class ReverseWords {


    //spilt
    public String reverseWords(String s) {

        if (s.length() == 0) {
            return "";
        }
        String[] s1 = s.trim().split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = s1.length - 1; i >= 0; i--) {
            if (s1[i].length() > 0) {
                sb.append(s1[i] + " ");
            }
        }

        return sb.toString().trim();
    }


    //双指针
    public String reverseWords1(String s) {
        String str = s.trim();
        int j = str.length() - 1, i = j;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            sb.append(str.substring(i + 1, j + 1) + " ");
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }

        return sb.toString().trim();
    }
}
