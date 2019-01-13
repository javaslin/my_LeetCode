public class IsPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }
        s = s.toLowerCase();
        int len = s.length();
        StringBuilder str = new StringBuilder(len);
        for (char c : s.toCharArray()) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                str.append(c);
            }
        }
        return str.toString().equals(str.reverse().toString());
    }
}
