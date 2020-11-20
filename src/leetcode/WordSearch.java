package leetcode;

public class WordSearch {

    public boolean exist(char[][] board, String word) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, word, 0, i, j)) return true;
            }
        }

        return false;
    }


    private boolean dfs(char[][] board, String word, int u, int x, int y) {

        if (board[x][y] != word.charAt(u)) return false;

        if (u == word.length() - 1) return true;

        char tmp = board[x][y];
        board[x][y] = '*';

        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int a = x + dx[i];
            int b = y + dy[i];
            if (a >= 0 && a < board.length && b >= 0 && b < board[a].length) {
                if (dfs(board, word, u + 1, a, b)) return true;
            }
        }

        board[x][y] = tmp;

        return false;
    }
}
