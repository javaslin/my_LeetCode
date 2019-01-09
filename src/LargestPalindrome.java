/*
你需要找到由两个 n 位数的乘积组成的最大回文数。

由于结果会很大，你只需返回最大回文数 mod 1337得到的结果。

示例:

输入: 2

输出: 987

解释: 99 x 91 = 9009, 9009 % 1337 = 987

说明:

n 的取值范围为 [1,8]。

当n==1时，最大的回文数是9，为奇数，单独做特殊情况处理；
当n为其他值时，最大的回文数都是偶数，所以可以利用字符串反转来得到所有的回文数。

得到回文数后，需要检查此回文数是否可以由两个数相乘得到（即，使此数依次除以某n位数，看余数是否为0）。若进行除法运算后，商大于n位数的最大值，则跳出此次循环，继续寻找下一个回文数。

 */
public class LargestPalindrome {
    public int largestPalindrome(int n) {
        if (n == 1)
            return 9;
        int upper = (int) Math.pow(10, n) - 1;
        for (int i = upper; i > upper / 10; i--) {
            long palin = toPalindrome(i);
            for (int j = upper; j > upper / 10; j--) {
                if (palin / j > upper)
                    break;
                if (palin % j == 0)
                    return (int) (palin % 1337);
            }
        }
        return -1;
    }

    public long toPalindrome(int i) {
        StringBuffer str = new StringBuffer();
        str.append(i + "");
        String a = str.reverse().toString();
        return Long.parseLong(i + "" + a);
    }

}
