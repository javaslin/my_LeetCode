package 模板;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Acwing 860 染色法判断二分图
 */
public class IsBipartiteGraph {

    static final int N = 100010, M = 200010;

    static int[] color = new int[N];

    static int n, m;

    static int[] h = new int[N];
    static int[] ne = new int[N];
    static int[] e = new int[N];
    static int idx;


    public static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }


    private static boolean dfs(int u, int c) {

        color[u] = c;
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (color[j] != 0) {
                if (!dfs(j, 3 - c)) return false;
            } else if (color[j] == c) return false;

        }

        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] s = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);

        Arrays.fill(h, -1);

        while (m-- > 0) {

            String[] s1 = bufferedReader.readLine().split(" ");

            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);

            add(a, b);
            add(b, a);
        }

        boolean flag = true;

        for (int i = 0; i < n; i++) {

            if (color[i] != 0) {
                if (!dfs(i, 1)) {
                    flag = false;
                    break;
                }
            }

        }


    }


}
