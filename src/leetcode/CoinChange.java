package leetcode;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int max=10000001;
        int[] f=new int[amount+1];
        Arrays.fill(f,max);
        f[0]=0;

        for (int i = 0; i <coins.length ; i++) {
            for (int j = coins[i]; j <=amount ; j++) {
                f[j]=Math.min(f[j],f[j-coins[i]]+1);
//                System.out.println("f["+j+"]"+"="+f[j]);
            }
        }
        if (f[amount] == max) {

            return -1;
        }
        return f[amount];



    }
}
