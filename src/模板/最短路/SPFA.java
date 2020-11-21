package 模板.最短路;

import sun.swing.StringUIClientPropertyKey;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class SPFA {

    static int INF = 0x3f3f3f;
    static int N = 10010;
    static int n;
    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] w = new int[N];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];

    static int idx = 0;


    public static int spfa() {
        Queue<Integer> queue = new LinkedList<>();

        Arrays.fill(dist, INF);

        dist[1] = 0;
        st[1] = true;

        queue.offer(1);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            st[poll] = true;

            for (int i = h[poll]; i != -1; i = ne[i]) {

                int j = e[i];

                if (dist[j] > dist[i] + w[i]) {
                    dist[j] = dist[i] + w[i];

                    if (!st[i]) {
                        queue.offer(j);
                        st[j] = true;
                    }
                }
            }
        }

        if (dist[n] == INF) return -1;

        return dist[n];
    }
}

