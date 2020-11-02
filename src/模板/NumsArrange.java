package 模板;

import java.io.*;
import java.util.*;

public class NumsArrange {
    static int n;
    static int[] path;
    static boolean[] st;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        n = Integer.valueOf(s);
        path = new int[n];
        st = new boolean[n + 1];
        dfs(0);
    }

    private static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(path[i] + " ");
            }
            System.out.println();
            return;
        } else {
            for (int i = 1; i <= n; i++) {
                if (!st[i]) {
                    path[u] = i;
                    st[i] = true;
                    dfs(u + 1);
                    st[i] = false;
                }
            }
        }
    }


}

