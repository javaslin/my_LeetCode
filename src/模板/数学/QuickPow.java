package 模板.数学;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author lin.shi on 2021/7/4
 * @project my_LeetCode
 */
public class QuickPow {


    //给定n组 abp,对于每组数据，求出pow(a,b) %p的值
    public static int quickPow(int a,int b,int p){
        int res=1;
        while (b!=0){
            if((b&1)!=0){//b&1 >> b的二进制个位为1 的时候
                res= res * a % p;
            }
            b>>=1;
            a=a * a % p;


        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(br.readLine());
        while (n--!=0){
            int[] nums= Arrays.stream(br.readLine().split(" ")).mapToInt(m->Integer.parseInt(m)).toArray();
            System.out.println(quickPow(nums[0],nums[1],nums[2]));
        }


    }
}
