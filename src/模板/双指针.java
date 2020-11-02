package 模板;

public class 双指针 {

    public static final int N = 100000;

    public static int n;

    public static int[] a = new int[N];

    public static int[] s = new int[N];


    //最长不包含重复数字子序列


    public static int longestNoDuplicatedNumArray(int n) {

        int res = 0;

        for (int i = 0, j = 0; i < n; i++) {

            s[a[i]]++;
            if (s[a[i]] > 1) {
                s[a[j]]--;
                j++;
            }

            res = Math.max(res, i - j + 1);


        }

        return res;

    }


    public static void template(int[] nums) {


        for (int i = 0, j = 0; i < nums.length; i++) {


            while (j <= i && check()) j++;

        }
    }


    public static boolean check() {

        boolean res = false;


        return res;
    }


    public static void main(String[] args) {

    }

}
