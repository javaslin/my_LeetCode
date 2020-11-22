package 模板;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Prim {


    static int n;
    static final int INF = 0x3f3f3f3f;
    static int N = 510;
    static int[][] g = new int[N][N];

    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];


    private static int prim() {
        Arrays.fill(dist, 0x3f);
        int res = 0;

        for (int i = 0; i < n; i++) {


            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!st[j] && (t == -1 || dist[t] > dist[j]))
                    t = j;
            }

            if (i != 0 && dist[t] == INF) return INF;

            if (i != 0) res += dist[t];
            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j], g[t][j]);
            }

            st[t] = true;

        }


        return res;

    }


    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = reader.readLine().split(" ");
        n = Integer.parseInt(str1[0]);
        int m = Integer.parseInt(str1[1]);
        for (int i = 1; i <= n; i++)
            Arrays.fill(g[i], INF);
        while (m-- > 0) {
            String[] str2 = reader.readLine().split(" ");
            int a = Integer.parseInt(str2[0]);
            int b = Integer.parseInt(str2[1]);
            int c = Integer.parseInt(str2[2]);
            g[a][b] = g[b][a] = Math.min(g[a][b], c);//若有重边，选择最短的
        }

        System.out.println(prim());

    }


}
