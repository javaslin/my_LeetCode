import java.util.*;

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


        int[] a = new int[]{73, 74, 75, 71, 69, 72, 76, 73};

        dailyTemperatures(a);


    }
}
