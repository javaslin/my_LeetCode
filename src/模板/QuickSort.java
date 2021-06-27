package 模板;

import java.util.Arrays;

public class QuickSort {


    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) return; //递归结束条件

        int i = l - 1;
        int j = r + 1;

        int mid = arr[l + ((r - l) >> 1)];//中间的数

        System.out.println("mid"+mid);
        while (i < j) {
            do {
                i++;
            } while (arr[i] < mid);

            do {
                j--;
            } while (arr[j] > mid);

            System.out.println("i:"+i+",j:"+j);
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            Arrays.stream(arr).forEach(num -> System.out.print(num+" "));
            System.out.println();
        }


        quickSort(arr, l, j);

        quickSort(arr, j + 1, r);


    }


    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 6, 7, 3, 2, 1, 9};
        Arrays.stream(arr).forEach(num -> System.out.print(num+" "));
        System.out.println();
        quickSort(arr, 0, arr.length - 1);



    }
}
