package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FriendCicle {

    static int[] p;


    private int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    private void union(int x, int y) {
        p[find(x)] = p[find(y)];
    }


    public int findCircleNum(int[][] M) {

        p = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            p[i] = i;
        }

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(i, j);
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < p.length; i++) {
            if (p[i] == i) ans++;
        }

        return ans;
    }
}
