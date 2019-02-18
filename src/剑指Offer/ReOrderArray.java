package 剑指Offer;

//调整数组顺序使奇数位于偶数前面
public class ReOrderArray {

    public void reOrderArray(int[] nums) {
        int oddCnt = 0;
        for (int val : nums) {
            if (val % 2 == 1) oddCnt++;
        }
        int i = 0, j = oddCnt;
        int[] copy = nums.clone();
        for (int val : copy) {
            if (val % 2 == 1)
                nums[i++] = val;
            else
                nums[j++] = val;
        }
    }
}
