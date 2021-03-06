package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MaxSubArrayLen {

    public int maxSubArrayLen(int[] nums,int k){
        Map<Integer,Integer> map=new HashMap<>();
        int res=0;
        int sum=0;
        map.put(0, -1);
        for (int i = 0; i < nums.length ; i++) {
            sum+=nums[i];
            if(map.containsKey(sum-k)){
                res=Math.max(res,i-map.get(sum-k));
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            System.out.println(entry.getKey()+"----"+entry.getValue());
        }

        return res;

    }
}
