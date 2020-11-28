package leetcode;

public class NumIsLandsIII {

    static int[] p;

    private int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }


    private void union(int a, int b) {
        p[find(b)] = p[find(a)];
    }


    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        p = new int[n * m];

        for (int i = 0; i < n * m; i++) {
            p[i] = i;

        }

        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{-1, 0, 1, 0};


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    for (int k = 0; k < 4; k++) {

                        int x = i + dx[k];
                        int y = j + dy[k];

                        if (x >= 0 && x < n && y >= 0 && y < m && grid[x][y] == '1') {
                            union(i * m + j, x * m + y);
                        }

                    }

                }
            }
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && p[i * m + j] == i * m + j) res++;
            }
        }

        return res;
    }
}
