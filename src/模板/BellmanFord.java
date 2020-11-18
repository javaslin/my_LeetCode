package 模板;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


/*
Acwing 853
 */
public class BellmanFord {

    static final int N = 510, M = 10010;

    static int n, m, k;

    static int[] dist = new int[N];

    static int[] backup = new int[N];

    static Edge[] list = new Edge[M];

    static int INF = 0x3f3f3f3f;


    static class Edge {
        int a;
        int b;
        int c;

        Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void bellman_ford() {


        Arrays.fill(dist, INF);
        dist[1] = 0;

        for (int i = 0; i < k; i++) {
            backup = Arrays.copyOf(dist, n + 1);

            for (int j = 0; j < m; j++) {

                Edge edge = list[j];
                int a = edge.a;
                int b = edge.b;
                int c = edge.c;
                dist[b] = Math.min(dist[b], backup[a] + c);
            }
        }
        if (dist[n] > INF / 2) System.out.println("impossible");
        else System.out.println(dist[n]);

    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = reader.readLine().split(" ");
        n = Integer.parseInt(str1[0]);
        m = Integer.parseInt(str1[1]);
        k = Integer.parseInt(str1[2]);
        for (int i = 0; i < m; i++) {
            String[] str2 = reader.readLine().split(" ");
            int a = Integer.parseInt(str2[0]);
            int b = Integer.parseInt(str2[1]);
            int c = Integer.parseInt(str2[2]);
            list[i] = new Edge(a, b, c);
        }
        bellman_ford();


    }

}
