package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CountPairs {
    public int countPairs(int[] deliciousness) {
        int res=0,mod=1000000007;
        Map<Integer,Integer> map=new HashMap<>();
        for (int num:deliciousness) {
            for (int i = 0; i <21 ; i++) {
                int t=(1<<i)-num;
                if(map.containsKey(t)){
                    res=(res+map.get(t))%mod;
                }
            }
            map.put(num, map.getOrDefault(num,0)+1);
        }

        return res;
    }
}
