package 模板.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoDimensionBag {
    static final int N=1010;
    static int a,b,c;
    static int[] v=new int[N];
    static int[] m=new int[N];
    static int[] w=new int[N];

    static int[][] f=new int[N][N];

    public static void main(String[] args) throws IOException {

        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String[] nums = br.readLine().split(" ");

        a = Integer.parseInt(nums[0]);
        b = Integer.parseInt(nums[1]);
        c=Integer.parseInt(nums[2]);

        for (int i = 1; i <= a; i++) {
            String[] nums1 = br.readLine().split(" ");
            v[i] = Integer.parseInt(nums1[0]);
            m[i]=Integer.parseInt(nums1[1]);
            w[i] = Integer.parseInt(nums1[2]);

        }

        for (int i = 1; i <=a ; i++) {
            for (int j = b; j >=v[i]; j--) {
                for (int k =c; k >=m[i] ; k--) {
                    f[j][k]=Math.max(f[j][k],f[j-v[i]][k-m[i]]+w[i]);
                }

                
            }
        }

        System.out.println(f[b][c]);

    }
}
