package 模板.数学;

/**
 * @author lin.shi on 2021/7/4
 * @project my_LeetCode
 */
public class IsPrimeNumber {

    //试除法判定指数
    //也叫辗转相除法

    public static boolean isPrime(int n){
        if(n<2) return false;

        for (int i = 2; i <n/i ; i++) {
            if(n%i==0){
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        System.out.println(isPrime(3));

        System.out.println(isPrime(13));

        System.out.println(isPrime(20));

    }
}
