import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

为了使插入操作不影响后续的操作，身高较高的学生应该先做插入操作，否则身高较小的学生原先正确插入的第 k 个位置可能会变成第 k+1 个位置。

身高降序、k 值升序，然后按排好序的顺序插入队列的第 k 个位置中。
 */
public class ReconstructQueue {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        for (int[] a : people) {
            System.out.println("[" + a[0] + "," + a[1] + "]");
        }
        List<int[]> queue = new ArrayList<>();
        for (int[] p : people) {
            queue.add(p[1], p);
        }
        return queue.toArray(new int[queue.size()][]);
    }

    public static void main(String[] args) {
        ReconstructQueue e = new ReconstructQueue();
        int[][] a = new int[][]{new int[]{7, 0}, new int[]{4, 4}, new int[]{7, 1}, new int[]{5, 0}, new int[]{6, 1}, new int[]{5, 2}};
        e.reconstructQueue(a);
    }
}
