package 模板.数学;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author lin.shi on 2021/7/4
 * @project my_LeetCode
 */
public class EulerFunction {
    //欧拉函数
    //给定n个正整数，求出每个数的欧拉函数

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line="";
        while ((line=br.readLine())!=null){
            int n=Integer.parseInt(line);
            int res=n;
            for (int i = 2; i <=n/i; i++) {
                if(n%i==0){
                    res=res/i*(i-1);
                    while (n%i==0){
                        n/=i;
                    }
                }
            }
            if(n>1){
                res=res/n*(n-1);
            }

            System.out.println(res);

        }


    }
}
