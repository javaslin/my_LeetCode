package leetcode;

/*
538. 把二叉搜索树转换为累加树
给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。

例如：

输入: 二叉搜索树:
              5
            /   \
           2     13

输出: 转换为累加树:
             18
            /   \
          20     13
 */
public class ConvertBST {
    public static class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;

        TreeNode(int x) {
            val = x;
        }
    }

    public int preNum = 0;

    public TreeNode convertBST(TreeNode root) {
        unPreOrder(root);
        return root;
    }

    public void unPreOrder(TreeNode root) {
        if (root == null)
            return;
        unPreOrder(root.right);
        root.val += preNum;
        preNum = root.val;
        unPreOrder(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(13);
        root.left = new TreeNode(2);
        ConvertBST convertBST = new ConvertBST();
        TreeNode r = convertBST.convertBST(root);
    }

}
