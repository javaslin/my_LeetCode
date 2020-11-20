package leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class IntersectionOfTwoArrays {


    public int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set1 = new HashSet<>();
        for (int num : nums1) {
            set1.add(num);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (int num : nums2) {
            set2.add(num);
        }

        if (set1.size() < set2.size()) {
            return intersectionSet(set1, set2);
        } else {
            return intersectionSet(set2, set1);
        }
    }


    public static int[] intersectionSet(HashSet<Integer> set1, HashSet<Integer> set2) {

        int[] output = new int[set1.size()];
        int idx = 0;
        for (Integer num : set1) {
            if (set2.contains(num)) output[idx++] = num;
        }
        return Arrays.copyOf(output, idx);
    }

}
