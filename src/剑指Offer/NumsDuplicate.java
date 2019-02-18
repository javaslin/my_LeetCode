package 剑指Offer;

//数组中重复的数字
public class NumsDuplicate {
    public boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || length <= 0) return false;
        for (int i = 0; i < length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;

    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[j] = nums[j];
        nums[j] = t;
    }
}
