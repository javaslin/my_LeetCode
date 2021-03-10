package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public List<Integer> inorderIter(TreeNode root){
        ans=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode p=root;
        while (p!=null || !stack.isEmpty()){
            while (p!=null){
                stack.push(p);
                p=p.left;
            }
            p=stack.pop();
            ans.add(p.val);
            p=p.right;
        }
        return ans;
    }


}
