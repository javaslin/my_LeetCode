package 模板;

public class MergeSort {


    public static void mergeSort(int[] nums, int l, int r) {

        if (l >= r) return;

        int mid = l + r >> 1;

        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);

        int[] temp = new int[r - l + 1];
        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (nums[i] >= nums[j]) temp[k++] = nums[j++];
            else temp[k++] = nums[i++];
        }
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= r) temp[k++] = nums[j++];

        for (i = l, j = 0; i <= r; i++, j++) {
            nums[i] = temp[j];
        }

    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 52, 234, 1231, 564, 756};
        mergeSort(nums, 0, nums.length - 1);
        for (int i : nums) {
            System.out.println(i);
        }

    }
}
