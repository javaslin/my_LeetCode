package 模板;

public class BitOperation {


    //整数n的二进制第k位是多少
    // 15=（1111）2
    public static int kthIs(int n, int k) {
        int i = n >> k;

        return i & 1;
    }


    //求整数n的二进制中有多少个1
    public static int howMuchOne(int n) {
        int res = 0;
        while (n != 0) {
            n -= lowbit(n);
            res++;
        }
        return res;
    }

    //返回n的最后一位1
    //x=1010,lowbit(x)=10
    //x=101000,lowbit(x)=1000
    public static int lowbit(int n) {
        return n & (~n + 1);
    }


    public static void main(String[] args) {
//        System.out.println(kthIs(15,3));

        System.out.println(howMuchOne(15));
    }

}
