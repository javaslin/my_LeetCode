package 模板.数学;

/**
 * @author lin.shi on 2021/7/4
 * @project my_LeetCode
 */
public class Divide {


    //辗转相除法分解质因数

    //给定n个正整数，将每个数分解质因数，并按照质因数的大小从小到大的顺序输出每个质因数的底数和指数
    public static void divide(int n){
        for (int i = 2; i <n/i ; i++) {
            int s=0;
            while (n%i==0){
                n/=i;
                s++;
            }
            System.out.println(i+","+s);

        }
        if(n>1) System.out.println(n+","+1);
    }


    public static void main(String[] args) {
        divide(20);
    }
}
