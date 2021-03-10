package 模板.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MixBag {


    static class Good{
        int kind;
        int v;
        int w;

        public Good(int kind, int v, int w) {
            this.kind = kind;
            this.v = v;
            this.w = w;
        }
    }

    static final int N=1010;
    static int[] f=new int[N];

    static int n,m;


    public static void main(String[] args) throws IOException {

        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader bf=new BufferedReader(in);
        String[] nm=bf.readLine().split(" ");

        List<Good> list=new ArrayList<>();

        n=Integer.parseInt(nm[0]);
        m=Integer.parseInt(nm[1]);

        for (int i = 1; i <=n ; i++) {
            String[] vws=bf.readLine().split(" ");
            int v=Integer.parseInt(vws[0]);
            int w=Integer.parseInt(vws[1]);
            int s=Integer.parseInt(vws[2]);
            if(s>0){
                for (int k = 1; k <=s ; k*=2) {
                    s-=k;
                    list.add(new Good(-1,v*k,w*k));
                }
                if(s>0) list.add(new Good(-1,v*s,w*s ));
            }else{
                list.add(new Good(s,v,w));
            }

        }

        for (Good good:list) {
            if(good.kind<0){
                for (int j = m; j >= good.v ; j--) {
                    f[j]=Math.max(f[j],f[j- good.v]+ good.w);
                }
            }else{
                for (int j = good.v; j <= m ; j++) {
                    f[j]=Math.max(f[j],f[j- good.v]+ good.w);
                }
            }
        }

        System.out.println(f[m]);


    }
}
