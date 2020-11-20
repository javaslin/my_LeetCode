package leetcode;

public class RemoverElements {


    public static void main(String[] args) {

        int[] a = new int[]{1, 3, 4, 3, 3};
        System.out.println(removeElement(a, 3));
    }


    public static int removeElement(int[] nums, int val) {
        int i = 0;
        int pointer = nums.length - 1;
        while (i <= pointer) {
            if (nums[i] == val) {
                nums[i] = nums[pointer];
                pointer--;
            } else {
                i++;
            }
        }
        return pointer + 1;
    }
}
