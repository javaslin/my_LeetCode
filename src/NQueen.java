public class NQueen {

    static int n;
    static char[][] g;
    static boolean col[], dg[], udg[];


    public static void dfs(int u) {
        if (u == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(g[i]);
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {


            if (!col[i] && !dg[u + i] && !udg[n - u + i]) {
                g[u][i] = 'Q';
                col[i] = dg[u + i] = udg[n - u + i] = true;
                dfs(u + 1);
                col[i] = dg[u + i] = udg[n - u + i] = false;
                g[u][i] = '.';
            }
        }

    }

    public static void main(String[] args) {
        int N = 20;
        g = new char[N][N];
        col = new boolean[N];
        dg = new boolean[N];
        udg = new boolean[N];

        n = 4;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = '.';
            }
        }

        dfs(0);

    }

}
