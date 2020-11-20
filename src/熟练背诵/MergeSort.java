package 熟练背诵;

public class MergeSort {

    public void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;

        int mid = l + r >> 1;

        mergeSort(arr, l, mid);

        mergeSort(arr, mid + 1, r);

        int[] temp = new int[r - l + 1];
        int k = 0, i = l, j = mid + 1;

        while (i <= mid && j <= r) {
            if (arr[i] >= arr[j]) temp[k++] = arr[j++];
            else temp[k++] = arr[i++];
        }

        while (i <= mid) temp[k++] = arr[i++];

        while (j <= r) temp[k++] = arr[j];

        for (i = l, j = 0; i <= r; i++, j++) {
            arr[i] = temp[j];
        }
    }
}
