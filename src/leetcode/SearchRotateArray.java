package leetcode;

import java.util.Arrays;

public class SearchRotateArray {

    public int search(int[] nums, int target) {

        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int i = binarySearch(copy, target);
        int a = 0;
        for (int j = 0; j < nums.length; j++) {
            if (copy[0] == nums[j]) {
                a = j;
            }
        }

        if (i == -1) {
            return -1;
        } else {
            return a + i;
        }


    }


    public int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;

    }
}
