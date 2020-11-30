package leetcode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    private List<List<Integer>> ans;
    private List<Integer> path;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        ans = new ArrayList<>();
        path = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        TreeNode node = root;
        dfs(root, sum, 0);

        return ans;
    }

    private void dfs(TreeNode node, int sum, int curSum) {
        if (node == null) return;
        curSum += node.val;
        path.add(node.val);
        if (curSum == sum && node.left == null && node.right == null) {
            ans.add(new ArrayList<>(path));
        }
        dfs(node.right, sum, curSum);
        dfs(node.left, sum, curSum);
        path.remove(path.size() - 1);
    }
}
