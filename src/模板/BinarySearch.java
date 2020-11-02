package 模板;

public class BinarySearch {


    public static boolean binarySearch(int[] nums, int target) {
        int left = 0, rignt = nums.length - 1;

        while (left <= rignt) {
            int mid = left + (rignt - left) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                rignt = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;

    }

    public static boolean copyBinarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == 0) {
                return true;
            } else if (nums[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 5, 3, 7, 4, 3, 9, 10, 45, 34, 56};
        System.out.println(binarySearch(nums, 34));

//        System.out.println(Integer.MAX_VALUE);
    }
}
