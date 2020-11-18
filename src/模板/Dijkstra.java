package 模板;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Acwing 849
 */
public class Dijkstra {


    static int N = 510;
    static int n;

    static int[][] g = new int[N][N];// 存储每条边
    static int[] dist = new int[N];// 存储1号点到每个点的最短距离
    static boolean[] st = new boolean[N];
    static int INF = 0x3f3f3f3f;//设置无穷大
    // 求1号点到n号点的最短路，如果不存在则返回-1


    private static int dijkstra() {

        //初始化dist
        for (int i = 0; i <= n; i++) {
            dist[i] = INF;
        }

        dist[1] = 0;

        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 1; j <= n; j++) {
                if (!st[j] && (t == -1 || dist[t] > dist[j])) {
                    t = j;
                }
            }
            st[t] = true;

            for (int j = 1; j <= n; j++) {
                dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
            }


        }
        if (dist[n] == INF) {
            return -1;
        }
        return dist[n];
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
            g[a][b] = Math.min(g[a][b], c);//若有重边，选择最短的
        }
        System.out.println(dijkstra());


    }


}
