package 模板.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WanQuanBagOptimize {

    static final int N = 1010;


    static int n, m;
    static int[] f = new int[N];

    static int[] v = new int[N];
    static int[] w = new int[N];

    public static void main(String[] args) throws IOException {
        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String[] nums = br.readLine().split(" ");

        n=Integer.parseInt(nums[0]);
        m=Integer.parseInt(nums[1]);

        for (int i = 1; i <=n ; i++) {
            String[] vM = br.readLine().split(" ");
            v[i]=Integer.parseInt(vM[0]);
            w[i]=Integer.parseInt(vM[1]);
        }

        for (int i = 1; i <=n ; i++) {
            for (int j = v[i]; j <=m; j++) {
                f[j]=Math.max(f[j],f[j-v[i]]+w[i]);// j-v[i] 已经算过--物品累加过程

            }
        }

        System.out.println(f[m]);

    }
}
