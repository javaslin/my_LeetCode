import java.util.ArrayList;
import java.util.List;

/*
448. 找到所有数组中消失的数字
给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。

找到所有在 [1, n] 范围之间没有出现在数组中的数字。

您能在不使用额外空间且时间复杂度为O(n)
的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。

示例:

输入:
[4,3,2,7,8,2,3,1]

输出:
[5,6]
 */
public class FindDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] n = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            n[nums[i] - 1]++;
        }
        for (int j = 0; j < n.length; j++) {
            if (n[j] == 0)
                list.add(j + 1);
        }
        return list;

    }

    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int p = Math.abs(nums[i]) - 1;
            if (nums[p] > 0) {
                nums[p] = 0 - nums[p];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindDisappearedNumbers findDisappearedNumbers = new FindDisappearedNumbers();
        int[] ints = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
    }
}