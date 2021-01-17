package leetcode;

public class DeleteTreeNode {
    class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
         this.left = left;
          this.right = right;
        }
  }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;

        if(key < root.val) root.left = deleteNode(root.left, key);
        else if(key > root.val) root.right = deleteNode(root.right, key);
        else
        {
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;

            //找到右子树的左下角
            TreeNode r = root.right;
            while(r.left != null) r = r.left;

            r.left = root.left;

            return root.right;
        }

        return root;



    }

}
