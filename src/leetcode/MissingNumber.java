package leetcode;

public class MissingNumber {


    public static void main(String[] args) {

        int[] a = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};

        System.out.println(missingNumber(a));


    }


    public static int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int sum = 0;
        int N = nums.length;
        for (int i = 0; i <= N - 1; i++) {
            sum += nums[i];
        }
        int NSum = N * (N + 1) / 2;
        return NSum - sum;
    }
}
