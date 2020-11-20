package leetcode;

import java.util.ArrayList;
import java.util.List;

public class InorderRecr {

    private List<Integer> ans;


    public List<Integer> inorderTraversal(BinaryTreeMinDepth.TreeNode root) {

        ans = new ArrayList<>();
        traversal(root);
        return ans;
    }


    private void traversal(BinaryTreeMinDepth.TreeNode root) {

        if (root == null) return;

        traversal(root.left);
        ans.add(root.val);
        traversal(root.right);

    }


}
