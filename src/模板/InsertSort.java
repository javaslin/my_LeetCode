package 模板;

import java.util.Arrays;

/**
 * @author lin.shi on 2021/6/27
 * @project my_LeetCode
 */
public class InsertSort {


    //数组中的每个元素，依次和它前面的元素比较
    //O(n2) 稳定
    private static void insertSort(int[] nums,int start,int end){
        for (int i = start; i <end ; i++) {
            for (int j = i; j >start ; j--) {
                if(nums[j]<nums[j-1]){
                    swap(nums,j,j-1);
                }else {
                    break;
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
        insertSort(arr,0, arr.length);
        Arrays.stream(arr).forEach(num -> System.out.print(num+" "));
    }
}
