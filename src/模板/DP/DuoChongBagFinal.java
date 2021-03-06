package 模板.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DuoChongBagFinal {

    static final int N = 20010;


    static int n, m;
    static int[] f = new int[N];

    static int[] v = new int[N];
    static int[] w = new int[N];
    static int[] s=new int[N];
    static int[] g=new int[N];
    static int[] q=new int[N];

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
            s[i]=Integer.parseInt(vM[2]);
        }

        for (int i = 1; i <=n ; i++) {
            g=Arrays.copyOf(f,f.length);
            for (int j = 0; j <v[i]; j++) {
                int hh=0,tt=-1;
                for (int k = j; k <=m; k+=v[i]) {
                    f[k]=g[k];
                    if(hh<=tt &&k-s[i]*v[i]>q[hh]) hh++;
                    if(hh<=tt) f[k]=Math.max(f[k],g[q[hh]]+(k-q[hh])/v[i]*w[i]);
                    while(hh<=tt && g[q[tt]]-(q[tt]-j)/v[i]*w[i]<=g[k]-(k-j)/v[i]*w[i]) tt--;
                    q[++tt]=k;
                }

            }
        }


        System.out.println(f[m]);

    }
}