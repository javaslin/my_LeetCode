package 熟练背诵;

import java.util.Arrays;

/**
 * @author lin.shi on 2021/6/29
 * @project my_LeetCode
 */
public class Sort {


    public static void quickSort(int[] nums,int l,int r){
        if(l>=r) return;

        int i=l-1;
        int j=r+1;

        int mid=nums[l+((r-l)>>1)];

        while (i<j){
            do {
                i++;
            }while (nums[i]<mid);

            do {
                j--;
            }while (nums[j]>mid);

            if(i<j){
                swap(nums,i,j);
            }
        }

        quickSort(nums,l,j);
        quickSort(nums,j+1,r);
    }


    public static void mergeSort(int[] nums,int l,int r){

        if(l>=r) return;

        int mid=l+r >>1;
        mergeSort(nums,l,mid);
        mergeSort(nums,mid+1,r);

        int[] temp=new int[r-l+1];

        int k=0;
        int i=l,j=mid+1;

        while (i<=mid && j<=r){
            if(nums[i]>=nums[j]){
                temp[k++]=nums[j++];
            }else {
                temp[k++]=nums[i++];
            }
        }

        while (i<=mid) temp[k++]=nums[i++];

        while (j<=r) temp[k++]=nums[j++];

        int u=0;
        for (int m = l; m <=r; m++) {
            nums[m]=temp[u++];
        }


    }


    private static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{3, 2, 6, 7, 3, 2, 1, 9};
        System.out.println();
        mergeSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(num -> System.out.print(num+" "));
    }


}
