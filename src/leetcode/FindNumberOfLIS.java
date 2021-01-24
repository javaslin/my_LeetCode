package leetcode;

import java.util.HashMap;
import java.util.Map;

public class FindNumberOfLIS {
    public int findNumberOfLIS(int[] nums) {
        int res=0;
        int[] f=new int[nums.length];
        int[] g=new int[nums.length];
        int maxl=1;
        for (int i = 0; i <nums.length; i++) {
            f[i]=1;
            g[i]=1;
            for (int j = 0; j <i ; j++) {
                if(nums[j]<nums[i]){
                    if (f[i] < f[j] + 1) {
                        f[i] = f[j] + 1;
                        g[i] = g[j];
                    }
                    else if (f[i] == f[j] + 1)
                        g[i] += g[j];
                }
                maxl = Math.max(maxl, f[i]);
            }
        }

        return res;

    }
}
