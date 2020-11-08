package 模板;

public class PrefixSum {

    static int[] s;


    public static void main(String[] args) {
        int[] nums = new int[]{3, 5, 2, 7, 4, 9, 5};

        s = new int[nums.length + 1];

        //前缀和的初始化
        s[0] = 0;
        for (int i = 1; i < nums.length + 1; i++) {
            s[i] = s[i - 1] + nums[i - 1];
        }

        // [l,r]区间的和
        int l = 3, r = 7;
        System.out.println(s[r] - s[l - 1]);
//
//        for (int num:s) {
//            System.out.println(num);
//        }
    }
}
