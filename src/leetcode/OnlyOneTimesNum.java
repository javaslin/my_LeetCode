package leetcode;

public class OnlyOneTimesNum {


    /**
     * 136. 只出现一次的数字
     *
     * @param nums
     * @return
     */

    public int singleNumber(int[] nums) {

        int single = 0;

        for (int num : nums) {
            single ^= num;
        }

        return single;

    }
}
