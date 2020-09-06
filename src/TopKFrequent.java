import java.util.*;

/*
Top K Frequent Elements (Medium)](https://leetcode.com/problems/top-k-frequent-elements/description/)

```html
Given [1,1,1,2,2,3] and k = 2, return [1,2].
```

设置若干个桶，每个桶存储出现频率相同的数，并且桶的下标代表桶中数出现的频率，即第 i 个桶中存储的数出现的频率为 i。

把数都放到桶之后，从后向前遍历桶，最先得到的 k 个数就是出现频率最多的的 k 个数。
 */
public class TopKFrequent {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0 && topK.size() < k; i--) {
            if (buckets[i] != null) {
                topK.addAll(buckets[i]);
            }
        }
        return topK;
    }


    public int[] topKFrequent1(int[] nums, int k) {

        //map存储num及其出现次数
        Map<Integer, Integer> occ = new HashMap<>();
        for (int num : nums) {
            occ.put(num, occ.getOrDefault(num, 0) + 1);

        }

        //最小堆
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        //遍历map
        for (Map.Entry<Integer, Integer> entry : occ.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (minHeap.size() == k) {
                //和堆顶元素比较出现次数
                if (minHeap.peek()[1] < count) {
                    minHeap.poll();
                    minHeap.offer(new int[]{num, count});
                }

            } else {
                minHeap.offer(new int[]{num, count});
            }
        }
        int[] res = new int[k];

        for (int i = 0; i < res.length; i++) {

            res[i] = minHeap.poll()[0];

        }

        return res;

    }
}
