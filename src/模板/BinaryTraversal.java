package 模板;

import 剑指Offer.TreeNode;

/**
 * @author lin.shi on 2021/7/24
 * @project my_LeetCode
 */
public class BinaryTraversal {

    public void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.val);
        inOrder(root.right);

    }

    public void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.println(root.val);
        preOrder(root.left);
        preOrder(root.right);

    }



    public void postOrder(TreeNode root){
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val);
    }


    public static void main(String[] args) {

    }
}
