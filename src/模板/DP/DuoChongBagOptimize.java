package 模板.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


class Pair{
    int v;
    int w;

    Pair(int v,int w){
        this.v=v;
        this.w=w;
    }
}
public class DuoChongBagOptimize {

    static final int N = 1010;


    static int n, m;
    static int[] f = new int[N];

    static int[] v = new int[N];
    static int[] w = new int[N];
    static int[] s=new int[N];

    public static void main(String[] args) throws IOException {
        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String[] nums = br.readLine().split(" ");


        List<Pair> pairs=new ArrayList<>();
        n=Integer.parseInt(nums[0]);
        m=Integer.parseInt(nums[1]);

        for (int i = 1; i <=n ; i++) {
            String[] vM = br.readLine().split(" ");
            v[i]=Integer.parseInt(vM[0]);
            w[i]=Integer.parseInt(vM[1]);
            s[i]=Integer.parseInt(vM[2]);
        }
        for (int i = 1; i <=n ; i++) {
            for (int k = 1; k <=s[i] ; k*=2) {
                s[i]-=k;
                pairs.add(new Pair(v[i]*k,w[i]*k));
            }
            if(s[i]>0) pairs.add(new Pair(v[i]*s[i],w[i]*s[i] ));
        }


        for (Pair pair:pairs) {
            for (int j = m; j >=pair.v ; j--) {
                f[j]=Math.max(f[j],f[j-pair.v]+pair.w);
            }
        }


        System.out.println(f[m]);

    }
}
