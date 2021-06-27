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

//        List<String> list=new ArrayList<>();
//        list.add("aaa");
//        System.out.println(list.get(0));


//
//
//        String str="test/161/feedback我";
////        System.out.println(str.substring(str.lastIndexOf("/")));
//
//        System.out.println(str.getBytes().length);

//
//        Long maxFileLength = Long.MAX_VALUE;
//        System.out.println(maxFileLength);

//
//        Map<Character,Integer> map=new HashMap<>();
//        int a=-9;
//        System.out.println(~a+1);


//        Deque<Integer> stack=new ArrayDeque<>();
////        stack.addLast(1);
////        stack.addLast(2);
////        stack.addLast(3);
//        System.out.println(stack.getLast());


//        int[] a = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
//
//        dailyTemperatures(a);


//        System.out.println(uniquePaths(7,3));
//        System.out.println(Integer.MAX_VALUE);
//        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
//
//        minHeap.offer(5);
//        minHeap.offer(3);
//        System.out.println(minHeap.peek());

//        Map<String, Integer> map = new TreeMap<>(new Comparator<String>() {
//            public int compare(String obj1, String obj2) {
//                return obj1.compareTo(obj2);
//            }
//        });
//        map.put("1",1);
//        map.put("1",2);
////        map.put("1077325",1);
////        map.put("1134583",1);
////        map.put("144176",1);
//
//        for (Map.Entry<String,Integer> entry:map.entrySet()) {
//            System.out.println(entry.getKey()+"   "+entry.getValue());
//        }


//        Stack<Integer> stack = new Stack<>();
//
//        stack.push(5);
//        stack.push(4);
//
//        System.out.println(stack.get(0));


//        System.out.println("" + 'a' + 'c');

//
//        Test test = new Test();
//        AtomicInteger a = new AtomicInteger(0);
//
//        test.change(a);
//
//        System.out.println(a.get());


//        String str = "  Bob    Loves  Alice   ";
//
//        String[] s = str.trim().split(" ");
//
//        System.out.println(s.length);
//        StringBuilder sb = new StringBuilder();
//        sb.toString();
//        Arrays.stream(s).forEach(num -> System.out.println(num.length())
//        a.toLowerCase().split("");
//        char[] front=s.substring(0,half).toLowerCase().split("");
//        char[] behind=s.substring(half,s.length()).toLowerCase().split("");


//        System.out.println(0&-1);

//        String str="22346735";
//        System.out.println(str.split("//").length);


//        for (int i = 1; i <4; i++) {
//            System.out.println(i);
//        }


//        System.out.println(Integer.MAX_VALUE);


//        String str1="eenpnn";

//        Stack<Character> stack=new Stack<>();
//        stack.push('[');
//        String str2="npnnee";
//
//        System.out.println(str1.compareTo(str2));


//        Date date1=new Date();
//        Thread.sleep(30000);
//        Date date2=new Date();
//
//        System.out.println(date1.getTime()-date2.getTime());


//        System.out.println(Math.abs(-2147483648-2147483647));
//        int[][] f=new int[1][1];


//        System.out.println(true);
//
//        BigInteger a=new BigInteger("0002");
//        BigInteger subtract = a.subtract(BigInteger.ONE);
//        System.out.println(subtract);


//        System.out.println(Integer.MAX_VALUE);



        String str="12:01";

        System.out.println(str.split(":")[1]);

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
