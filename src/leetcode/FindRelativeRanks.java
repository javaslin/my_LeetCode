package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
506. 相对名次
给出 N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。

(注：分数越高的选手，排名越靠前。)

示例 1:

输入: [5, 4, 3, 2, 1]
输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
提示:

N 是一个正整数并且不会超过 10000。
所有运动员的成绩都不相同。
 */
public class FindRelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        int nums2[] = new int[nums.length];
        for (int j = 0; j < nums.length; j++) {
            nums2[j] = nums[j];
        }
        Arrays.sort(nums2);
        int i = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = nums.length - 1; j >= 0; j--) {
            map.put(nums2[j], i);
            i++;
        }
        String[] s = new String[nums.length];
        for (int j = 0; j < nums.length; j++) {
            int temp = map.get(nums[j]);
            if (temp == 1) {
                s[j] = "Gold Medal";
            } else if (temp == 2) {
                s[j] = "Silver Medal";
            } else if (temp == 3) {
                s[j] = "Bronze Medal";
            } else {
                s[j] = "" + temp;
            }
        }
        return s;
    }
}
