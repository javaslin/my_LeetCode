package 模板;

import java.util.Arrays;

/**
 * @author lin.shi on 2021/6/27
 * @project my_LeetCode
 */
public class SelectSort {


    //从第一个元素开始，和每个元素比较，每一趟使选出一个最小的数
    private static void selectSort(int[] nums,int start,int end){
        for (int i = 0; i <end ; i++) {
            for (int j = i+1; j <end ; j++) {
                if(nums[i]>nums[j]){
                    swap(nums, i, j);
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
            selectSort(arr,0, arr.length);
            Arrays.stream(arr).forEach(num -> System.out.print(num+" "));
    }
}
