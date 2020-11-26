package leetcode;

public class FindDuplicate {

    public int findDuplicate(int[] nums) {
        int l = 1, r = nums.length - 1;


        while (l < r) {
            int mid = l + r >> 1;
            int s = 0;
            for (int num : nums) {
                s += num >= l && num <= mid ? 1 : 0;
            }
            if (s > mid - l + 1) r = mid;
            else l = mid + 1;
        }
        return r;
    }
}
