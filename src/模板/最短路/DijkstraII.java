package 模板.最短路;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraII {
    static int N = 100010;
    static int n;

    static int[] h = new int[N];
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static int[] w = new int[N];
    static int idx = 0;
    static int[] dist = new int[N];// 存储1号点到每个点的最短距离
    static boolean[] st = new boolean[N];
    static int INF = 0x3f3f3f3f;//设置无穷大

    public static void add(int a, int b, int c) {
        e[idx] = b;
        w[idx] = c;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    // 求1号点到n号点的最短路，如果不存在则返回-1
    public static int dijkstra() {
        //维护当前未在st中标记过且离源点最近的点
        PriorityQueue<PIIs> queue = new PriorityQueue<PIIs>();
        Arrays.fill(dist, INF);
        dist[1] = 0;
        queue.add(new PIIs(0, 1));
        while (!queue.isEmpty()) {
            //1、找到当前未在s中出现过且离源点最近的点
            PIIs p = queue.poll();
            int t = p.getSecond();
            int distance = p.getFirst();
            if (st[t]) continue;
            //2、将该点进行标记
            st[t] = true;
            //3、用t更新其他点的距离
            for (int i = h[t]; i != -1; i = ne[i]) {
                int j = e[i];
                if (dist[j] > distance + w[i]) {
                    dist[j] = distance + w[i];
                    queue.add(new PIIs(dist[j], j));
                }
            }

        }
        if (dist[n] == INF) return -1;
        return dist[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = reader.readLine().split(" ");
        n = Integer.parseInt(str1[0]);
        int m = Integer.parseInt(str1[1]);
        Arrays.fill(h, -1);
        while (m-- > 0) {
            String[] str2 = reader.readLine().split(" ");
            int a = Integer.parseInt(str2[0]);
            int b = Integer.parseInt(str2[1]);
            int c = Integer.parseInt(str2[2]);
            add(a, b, c);
        }
        System.out.println(dijkstra());
    }
}

class PIIs implements Comparable<PIIs> {
    private int first;//距离值
    private int second;//点编号

    public int getFirst() {
        return this.first;
    }

    public int getSecond() {
        return this.second;
    }

    public PIIs(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(PIIs o) {
        return Integer.compare(first, o.first);
    }
}



