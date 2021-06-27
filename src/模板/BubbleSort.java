package 模板;

import java.util.Arrays;

/**
 * @author lin.shi on 2021/6/27
 * @project my_LeetCode
 */
public class BubbleSort {


    //相邻元素互换
    private static void bubbleSort(int[] nums,int start,int end){
        for (int i = end; i >start ; i--) {
            for (int j = start; j <i ; j++) {
                if(nums[j]>nums[j+1]){
                    swap(nums, j+1, j);
                }
            }
        }

    }
    private static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2, 11, 6, 7, 8, 2, 1, 9};
        bubbleSort(arr,0, arr.length-1);
        Arrays.stream(arr).forEach(num -> System.out.print(num+" "));
    }
}
