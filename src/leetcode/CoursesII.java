package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CoursesII {
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

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res=new int[numCourses];
        int index=0;
        if(prerequisites.length==0){
            for (int i = numCourses-1; i >=0 ; i--) {
                res[index++]=i;
            }
            return res;
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
            res[index++]=poll.intValue();
            for (int i = h[poll]; i != -1; i = ne[i]) {
                int j = e[i];
                if (--d[j] == 0) {
                    queue.add(j);

                }
            }
        }
        if(count!=numCourses) return new int[]{};

        return res;


    }


    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 0}};

        CoursesII courses = new CoursesII();
        int[] ints = courses.findOrder(2, a);

        for (int i = 0; i < ints.length ; i++) {
            System.out.print(ints[i]+" ");
        }

    }
}
