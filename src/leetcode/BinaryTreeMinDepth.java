package leetcode;

public class BinaryTreeMinDepth {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return getMin(root);
    }


    public int getMin(TreeNode node) {

        if (node == null) {
            return Integer.MAX_VALUE;
        }

        if (node.right == null && node.left == null) {
            return 1;
        }

        return Math.min(getMin(node.left), getMin(node.right)) + 1;
    }


}
