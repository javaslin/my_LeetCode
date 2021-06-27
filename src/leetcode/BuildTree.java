package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class BuildTree {


    Map<Integer,Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n= inorder.length;
        map=new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return dfs(preorder,inorder,0,n-1,0,n-1);

    }


    private TreeNode dfs(int[] preorder, int[] inorder,int pl,int pr,int il,int ir){

        if(pl>pr) return null;

        int val=preorder[pl];
        int k=map.get(val);
        int len=k-il;
        TreeNode root=new TreeNode(val);
        root.left=dfs(preorder, inorder, pl+1, pl+len, il, k-1);
        root.right=dfs(preorder, inorder, pl+len+1, pr, k+1, ir);
        return root;
    }
}
