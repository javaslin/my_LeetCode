package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxNum {



    public String largestNumber(int[] nums) {
        StringBuffer sb=new StringBuffer();
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i <nums.length ; i++) {
            list.add(nums[i]);
        }

        list.sort((o1,o2)->(o2.toString()+o1.toString()).compareTo(o1.toString()+o2.toString()));
        for (Integer num:list) {
            sb.append(num);
        }
        //处理前面是零的情况
        int k = 0;
        while(k < sb.length() - 1 && sb.charAt(k) == '0') k ++;
//        for (int i = 0; i <sb.length() ; i++) {
//            if(sb.charAt(i)=='0'){
//                return sb.substring(i-1,sb.length());
//            }
//        }
        return sb.substring(k);
    }

}
