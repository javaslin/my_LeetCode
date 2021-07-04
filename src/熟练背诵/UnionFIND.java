package 熟练背诵;

/**
 * @author lin.shi on 2021/7/1
 * @project my_LeetCode
 */
public class UnionFIND {
    static final int N=10000;

    static int n;

    static final int[] p=new int[N];

    static final int[] size=new int[N];


    private static int find(int x){
        if(p[x]!=x){
            p[x] =find(p[x]);
        }

        return p[x];
    }

    private static void union(int x,int y){
        p[find(x)]=p[find(y)];
    }






}
