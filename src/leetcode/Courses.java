package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Courses {
    static final int N = 100010;

    private int[] e;
    private int[] ne;
    private int[] h;
    private int idx;

    private int[] d;


    private void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 1 || prerequisites.length == 0) {
            return true;
        }
        Queue<Integer> queue = new LinkedList<>();
        e = new int[N];
        ne = new int[N];
        h = new int[N];
        d = new int[numCourses];
        Arrays.fill(h, -1);
        for (int i = 0; i < prerequisites.length; i++) {
            add(prerequisites[i][1], prerequisites[i][0]);
            d[prerequisites[i][0]]++;
        }
        for (int i = 0; i < d.length; i++) {
            if (d[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            count++;
            for (int i = h[poll]; i != -1; i = ne[i]) {
                int j = e[i];
                if (--d[j] == 0) {
                    queue.add(j);
                }
            }
        }

        return count == numCourses;

    }


    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 0}};

        Courses courses = new Courses();
        System.out.println(courses.canFinish(2, a));

    }
}
