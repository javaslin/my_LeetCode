package leetcode;

import java.util.Arrays;

public class MinSubArrayLen {


    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int ans = n + 1;
        int cur = 0;

        for (int i = 0, j = 0; i < n; i++) {
            cur += nums[i];
            while (j <= i && cur >= s) {
                cur -= nums[j];
                j++;
            }

            if (j > 0)
                ans = Math.min(ans, i - j + 2);
        }

        if (ans == n + 1)
            ans = 0;

        return ans;

    }


}
