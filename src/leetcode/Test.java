package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;
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


    public static void main(String[] args) {

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


        String str = "  Bob    Loves  Alice   ";

        String[] s = str.trim().split(" ");

        System.out.println(s.length);
        Arrays.stream(s).forEach(num -> System.out.println(num.length()));


    }
}
