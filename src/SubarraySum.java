import java.util.HashMap;
import java.util.Map;

public class SubarraySum {


    //朴素 超时
    public static int subarraySum(int[] nums, int k) {

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = sumArray(nums, i, j);
                if (sum == k) {
                    res++;
                }
            }
        }
        return res;

    }

    private static int sumArray(int[] nums, int start, int end) {
        int res = 0;

        for (int i = start; i <= end; i++) {
            res += nums[i];
        }

        return res;
    }

    //前缀和+哈希
    public int subarraySum1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        int ans = 0, sum = 0;
        /*
        用前缀和sum记录[0,i]的和，并在i之前能否找到[0,j]和为sum-k的情况，为什么是sum-k呢，因为
        [0,j]+[j+1,i]=[0,j] => [0,j]+k=sum => [0,j]=sum-k
        就需要把每次的sum作为key，出现的次数作为value保存起来
        */
        for (int n : nums) {
            sum += n;
            if (sum == k) ans++;//这个算法不能处理[0,i]就已经是k的情况，所以要额外加一次[0,i]的，在循环外面加map.put(0,1)也是可以的
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            while (map.get(s.charAt(j)) > 1) {
                map.put(s.charAt(i++), map.get(s.charAt(i - 1)) - 1);
            }
            res = Math.max(res, j - i + 1);
        }

        return res;

    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        System.out.println(subarraySum(nums, 2));
    }
}
