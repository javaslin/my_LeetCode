package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumTeachings {
    //找出没有共同语言的所有人会的最多的语言,再用没有共同语言的人数减去会的最多语言的人数
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<friendships.length;i++){
            if(!hasSameLan(friendships[i][0],friendships[i][1],languages)){
                set.add(friendships[i][0]);
                set.add(friendships[i][1]);
            }
        }
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:set){
            for(int j=0;j<languages[num-1].length;j++){
                map.put(languages[num-1][j], map.getOrDefault(languages[num-1][j],0)+1);
            }
        }
        int max=0;
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            max=Math.max(max,entry.getValue());
        }
        return set.size()-max;

    }

    public boolean hasSameLan(int i,int j,int[][] languages){
        int[] ai=languages[i-1];
        int[] aj=languages[j-1];
        for(int k=0;k<ai.length;k++){
            for(int l=0;l<aj.length;l++){
                if(ai[k]==aj[l]){
                    return true;
                }
            }
        }
        return false;

    }
}
