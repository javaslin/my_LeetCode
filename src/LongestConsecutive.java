import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {


    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longRes = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLong = 0;

                while (set.contains(currentNum + 1)) {
                    currentLong += 1;
                    currentNum += 1;
                }
                longRes = Math.max(currentLong, longRes);

            }
        }
        return longRes;
    }
}
