package 熟练背诵;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DFS {
    public static void main(String[] args) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=1;i<=10;i++){
            int sum=0;
            int x=i;
            while(x!=0){
                sum+=x%10;
                x=x/10;
//                System.out.println(sum);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }

        int max=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
            max=Math.max(max,entry.getValue());
        }
    }
}
