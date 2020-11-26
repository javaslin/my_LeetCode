package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if (i != 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1, r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];

                if (sum > 0) {
                    r--;
                    continue;
                }
                if (sum < 0) {
                    l++;
                    continue;
                }

                ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                do {
                    l++;
                } while (l < r && nums[l] == nums[l - 1]);

                do {
                    r--;
                } while (l < r && nums[r] == nums[r + 1]);
            }

        }
        return ans;

    }
}
