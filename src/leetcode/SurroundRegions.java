package leetcode;

public class SurroundRegions {


    //将矩阵中四周为O的坐标 dfs
    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;
        if (n == 0) return;

        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }
            if (board[n - 1][i] == 'O') {
                dfs(board, n - 1, i);
            }
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][m - 1] == 'O') {
                dfs(board, i, m - 1);
            }
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'U') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }


    }


    public void dfs(char[][] board, int x, int y) {
        if (board[x][y] == 'U' || board[x][y] == 'X')
            return;
        board[x][y] = 'U';
        int[] dx = new int[]{0, 1, 0, -1};
        int[] dy = new int[]{-1, 0, 1, 0};

        for (int i = 0; i < 4; i++) {
            int x1 = x + dx[i];
            int y1 = y + dy[i];
            if (x1 >= 0 && x1 < board.length && y1 >= 0 && y1 < board[0].length && board[x1][y1] == 'O') {
                dfs(board, x1, y1);
            }
        }


    }

}
