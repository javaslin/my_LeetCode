package leetcode;

public class FindPeakElement {

    public static int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        if (nums.length == 2) {
            if (nums[0] > nums[1]) {
                return 0;
            } else {
                return 1;
            }
        }
        int n = nums.length;
        int l = 0, r = n - 1;
        int mid = l + (r - l) / 2;

        while (mid + 1 < nums.length && mid - 1 >= 0) {
            if (nums[mid - 1] < nums[mid] && nums[mid + 1] < nums[mid]) {
                return mid;
            } else if (nums[mid - 1] > nums[mid]) {
                mid = mid - 1;
            } else if (nums[mid + 1] > nums[mid]) {
                mid = mid + 1;
            }
        }


        return mid;


    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(findPeakElement(nums));
    }
}
