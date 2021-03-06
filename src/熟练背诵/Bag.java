package 熟练背诵;

public class Bag {
    static final  int N=1010;



    public static int zeroOneBagTwoDimension(int[] v,int[] w,int m){
        //m 为背包体积 v 各物品体积 w 各物品价值


        int n=v.length-1;
        //n 物品个数

        int[][] f=new int[N][N];

        
        //f[i][j] 表示 选前i个物品 总体积为j时的 最大价值
        for (int i = 1; i <=n ; i++) {
            for (int j = 0; j <=m ; j++) {
                f[i][j]=f[i-1][j];
                if(j>=v[i]){
                    f[i][j]=Math.max(f[i][j],f[i-1][j-v[i]]+w[i]);
                }
            }
        }

        return f[n][m];


    }
    public static int zeroOneBagOneDimension(int[] v,int[] w,int m){


        //m 为背包体积 v 各物品体积 w 各物品价值


        int n=v.length-1;
        //n 物品个数

        int[] f=new int[N];

        for (int i = 1; i <=n ; i++) {
            for (int j = m; j >=v[i]; j--) {
                f[j]=Math.max(f[j],f[j-v[i]]+w[i]);
            }
        }

        return f[m];
    }


    public static void main(String[] args) {
        int m=5;
        int[] v=new int[]{0,1,2,3,4};
        int[] w=new int[]{0,2,4,4,5};

        System.out.println(zeroOneBagOneDimension(v,w,m));
    }
}
