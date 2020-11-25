package leetcode;


import java.util.LinkedList;
import java.util.Queue;

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class OrangeRotting {


    public int orangesRotting(int[][] grid) {

        int res = bfs(grid);

        if (check(grid)) {
            return res;
        } else {
            return -1;
        }
    }


    private boolean check(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return false;
                }
            }
        }

        return true;

    }


    public int bfs(int[][] grid) {

        int ans = 0;


        Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {

            int queueSize = queue.size();

            int modCount = 0;
            for (int m = 0; m < queueSize; m++) {
                Pair poll = queue.poll();

                if ((poll.x == -1 && poll.y == -1)) {
                    return ans;
                }

                int[] dx = new int[]{0, 1, 0, -1};
                int[] dy = new int[]{-1, 0, 1, 0};


                for (int i = 0; i < 4; i++) {
                    int x = poll.x + dx[i];
                    int y = poll.y + dy[i];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[x].length) {
                        if (grid[x][y] == 1) {
                            grid[x][y] = 2;
                            modCount++;
                            queue.offer(new Pair(x, y));
                        }
                    }
                }

            }
            if (modCount > 0) {
                ans++;
            }

        }
        return ans;

    }
}
