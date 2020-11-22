package 模板;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


class Edge implements Comparable<Edge> {
    int a;
    int b;
    int w;

    Edge(int a, int b, int w) {
        this.a = a;
        this.b = b;
        this.w = w;
    }


    @Override
    public int compareTo(Edge o) {
        return Integer.compare(w, o.w);
    }
}

/*
Acwing 859
 */
public class Kruskal {


    static int N = 100010;
    static int M = 200010;
    static int INF = 0x3f3f3f3f;

    static int n;

    static Edge[] edges = new Edge[M];
    static int[] p = new int[N];

    private static int find(int x) {

        if (p[x] != x) p[x] = find(p[x]);

        return p[x];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = reader.readLine().split(" ");
        n = Integer.parseInt(str1[0]);
        int m = Integer.parseInt(str1[1]);
        for (int i = 0; i < m; i++) {
            String[] str2 = reader.readLine().split(" ");
            int a = Integer.parseInt(str2[0]);
            int b = Integer.parseInt(str2[1]);
            int c = Integer.parseInt(str2[2]);
            edges[i] = new Edge(a, b, c);
        }

        Arrays.sort(edges, 0, m);

        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }


        int res = 0, count = 0;
        for (int i = 0; i < m; i++) {

            Edge edge = edges[i];

            int a = edge.a;
            int b = edge.b;
            int w = edge.w;

            a = find(a);
            b = find(b);
            if (a != b) {
                p[a] = b;
                res += w;
                count++;
            }

        }
        System.out.println(res);


    }


}
