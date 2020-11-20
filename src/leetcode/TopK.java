package leetcode;

import java.util.PriorityQueue;

public class TopK {


    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < nums.length; i++) {
            maxHeap.offer(nums[i]);
        }

        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }

        return maxHeap.poll();

    }

}
