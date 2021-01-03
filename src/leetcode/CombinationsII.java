package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationsII {

    static List<List<Integer>> res;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        res=new ArrayList<>();
        List<Integer> path=new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates,target,0,path,res);
        return res;

    }

    public static void dfs(int[] candidates,int target,int start,List<Integer> path,List<List<Integer>> res) {
        path.stream().forEach(num -> {
            System.out.print(num+" ");

        });
        System.out.println();
        if(target<0){
            return;
        }

        if(target==0){
            res.add(new ArrayList<>(path));
        }

        for (int i = start; i <candidates.length ; i++) {
            if(i>start && candidates[i]==candidates[i-1]) continue;
            path.add(candidates[i]);
            dfs(candidates,target-candidates[i],i+1,path,res);
            path.remove(path.size()-1);
        }



    }

    public static void main(String[] args) {

        int[] a=new int[]{10,1,2,7,6,1,5};
        combinationSum(a,8);

    }
}
