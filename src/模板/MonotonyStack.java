package 模板;

import java.util.Stack;

/**
 * @author lin.shi on 2021/6/27
 * @project my_LeetCode
 */
public class MonotonyStack {
    //单调栈一般用来求数组中某个数左边/右边第一个比它小/大的数
    //求左边第一个小于它的数：维护一个沿栈顶方向递增的栈，并从头到尾遍历数组
    //求左边第一个大于它的数：维护一个沿栈顶方向递减的栈，并从头到尾遍历数组
    //求右边第一个小于它的数：维护一个沿栈顶方向递增的栈，并从尾到头遍历数组
    //求右边第一个大于它的数：维护一个沿栈顶方向递减的栈，并从尾到头遍历数组


    //
    public static void monotonyStack(int[] nums){
        int N=1000;

        int[] stack=new int[N];

        int tt=0;

        for (int i = 0; i <nums.length ; i++) {
            while (tt!=0 && stack[tt]>=nums[i]) tt--;
            if(tt!=0){
                System.out.print(stack[tt]+" ");
            }else {
                System.out.printf("-1 ");
            }
            stack[++tt]=nums[i];
        }

    }

    public static void monotonyStackAPI(int[] nums){
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < nums.length ; i++) {
            while (!stack.isEmpty() && stack.peek()>=nums[i]) stack.pop();
            if(!stack.isEmpty()){
                System.out.print(stack.peek()+" ");
            }else {
                System.out.print("-1 ");
            }
            stack.push(nums[i]);
        }
    }

    //右边第一个比他大的数，最后需翻转数组
    public static void monotonyStack1(int[] nums){
        final int N=1000;

        int[] stack=new int[N];

        int tt=0;


        for (int i = nums.length-1; i >=0 ; i--) {
            while (tt!=0 && stack[tt]<=nums[i]) tt--;
            if(tt!=0){
                System.out.print(stack[tt]+" ");
            }else {
                System.out.printf("-1 ");
            }
            stack[++tt]=nums[i];
        }

    }


    public static void main(String[] args) {
        int[] nums=new int[]{3,7,2,5,1,1,4,9};
        monotonyStackAPI(nums);
        System.out.println();
        monotonyStack(nums);
//        singleStackS(nums);
    }


}
