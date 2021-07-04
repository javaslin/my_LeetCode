package 模板;

import java.util.Arrays;

/**
 * @author lin.shi on 2021/7/2
 * @project my_LeetCode
 */
public class HeapSort {

    static int size=0;


    public static void heapSort(int[] nums){
        int n= nums.length;
        size= n-1;
        for (int i = n/2; i !=0 ; --i) {
            down(nums,i);
        }

    }

    private static void down(int[] heap,int n){
        int x = n;
        if(n * 2 <= size && heap[x] > heap[n * 2])x = n * 2;
        if(n * 2 + 1 <= size && heap[x] > heap[n * 2 + 1])x = n * 2 + 1;
        if(n != x){
            swap(heap,n, x);
            down(heap,x);
        }
    }

    private static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,2, 11, 6, 7, 8, 2, 1, 9};
        heapSort(arr);
        for (int i = 1; i <= 8 ; i++) {
            System.out.println(arr[1]);
            arr[1]=arr[size];
            size--;
            down(arr,1);
        }
    }
}
