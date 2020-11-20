package 熟练背诵;

public class QuickSort {


    public void quickSort(int[] arr, int l, int r) {

        if (l >= r) return;

        int i = l - 1, j = r + 1;

        int mid = arr[l + ((r - l) >> 1)];

        while (i < j) {
            do {
                i++;
            } while (arr[i] < mid);

            do {
                j--;
            } while (arr[j] > mid);

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        quickSort(arr, l, j);

        quickSort(arr, j + 1, r);


    }
}
