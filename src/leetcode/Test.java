package leetcode;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {


    private static Student student;

    private static Student student1;

    private static Student student2;


    static {
        student = new Student("tom", "");

        student1 = new Student("mac", "");

        student2 = new Student("xiaohong", "");

    }

    public int rand10() {
        while (true){
            int num=(rand7()-1)*7+rand7();

            //如果在40以内，那就直接返回
            if(num <= 40){
                return 1 + num % 10;
            }
            // 说明刚才生成的在41-49之间，利用随机数再操作一遍
            num = (num - 40 - 1) * 7 + rand7();
            if(num <= 60){
                return 1 + num % 10;
            }
            // 说明刚才生成的在61-63之间，利用随机数再操作一遍
            num = (num - 60 - 1) * 7 + rand7();
            if(num <= 20){
                return 1 + num % 10;
            }

        }
    }

    public int rand7(){

        while (true){
            int num=10;
            if(num>100){
                return 10;
            }
        }

    }

    public static int[] dailyTemperatures(int[] T) {

        int n = T.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque();
        // 单调递减的单调栈：index to be resolved
        //栈中存放的是暂时还未找到结果的元素的下标
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && T[stack.getLast()] < T[i]) {
                res[stack.getLast()] = i - stack.getLast();
                stack.removeLast();
            }
            stack.addLast(i);
        }
        return res;
    }

    public int findUnsortedSubarray(int[] nums) {


        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] copyArray = Arrays.copyOf(nums, nums.length);

        Arrays.sort(copyArray);

        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (copyArray[i] != nums[i]) {
                start = i;
                break;
            }

        }
        int end = 0;
        for (int i = nums.length; i > 0; i--) {
            if (copyArray[i] != nums[i]) {
                end = i;
                break;
            }

        }
        return end - start + 2;
    }


    public void change(AtomicInteger integer) {
        integer.getAndIncrement();
        integer.getAndIncrement();

    }


    public static void main(String[] args) throws InterruptedException {




//        String str="{\"jobId\":49,\"params\":{\"filterLogicExp\":\"(condition1)\",\"mainOneArray\":[{\"filterConditionName\":\"condition1\",\"formName\":\"appForm\"}],\"outputPath\":\"/datacloud/dss/atm/msp-job-service/202107/151507251791741745020/output\",\"name\":\"会计学习AppList\",\"deptId\":4.0,\"excludeCheatedIds\":0.0,\"mainTwoArray\":[],\"conditions\":[{\"exps\":[{\"outputFilter\":\"21\",\"type\":\"device\",\"expCode\":\"02000\"}],\"expType\":\"outputDetail\"}";
////
//        System.out.println(str.replace(".0",""));

        String str="/a/b";
        System.out.println(str.replace("/",""));


    }
    public boolean splitString(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (dfs(i, new BigInteger(s.substring(0, i)), s)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int start, BigInteger prev, String s) {
        if (start == s.length()) {
            return true;
        } else {
            for (int i = start + 1; i <= s.length(); i++) {
                if (new BigInteger(s.substring(start, i)).equals(prev.subtract(BigInteger.ONE))
                        && dfs(i, new BigInteger(s.substring(start, i)), s)) {
                    return true;
                }
            }
            return false;
        }
    }

    public int numberOfRounds(String startTime, String finishTime)  {

        SimpleDateFormat format=new SimpleDateFormat("HH:mm");

        String s = startTime.split(":")[1];
        int startHour= Integer.parseInt(startTime.split(":")[0]);
        int startM=Integer.parseInt(s);
        if(startM>0&&startM<15){
            startM=15;
        }else if(startM>15&&startM<30){
            startM=30;
        }else if(startM>30&&startM<45){
            startM=45;
        }else{
            startM=0;
            startHour+=1;
        }

        String s1 = finishTime.split(":")[1];
        int endHour=Integer.parseInt(finishTime.split(":")[0]);
        int endM=Integer.parseInt(s1);
        if(endM>0&&endM<15){
            endM=0;
            if(endHour!=0){
                endHour-=1;
            }else {
                endHour=23;
            }
        }else if(endM>15&&endM<30){
            endM=15;
        }else if(endM>30&&endM<45){
            endM=30;
        }else{
            endM=45;
        }

        try {
            if(format.parse(finishTime).getTime()<format.parse(startTime).getTime()){
                endHour+=24;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(endHour);




        int startMinute=startHour*60+startM;
        int endMinute=endHour*60+endM;

        return (endMinute-startMinute)/15;



    }

}
