package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permute {

    static int n;
    static int[] path;
    static boolean[] st;
    static List<List<Integer>> res;


    public static List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();

        n = nums.length;
        path = new int[n];
        st = new boolean[n + 1];
        dfs(0, nums);
        return res;

    }

    private static void dfs(int u, int[] nums) {
        if (u == n) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(path[i]);
            }
            res.add(list);
            return;
        } else {
            for (int i = 0; i < n; i++) {
                if (!st[i]) {
                    path[u] = nums[i];
                    st[i] = true;
                    dfs(u + 1, nums);
                    st[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 6, 5};
        permute(nums);
    }


}
