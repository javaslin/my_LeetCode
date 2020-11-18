package 模板;

import java.util.*;
import java.io.*;

/*
5 5
0 1 0 0 0
0 1 0 1 0
0 0 0 0 0
0 1 1 1 0
0 0 0 1 0
 */
//存储路径
class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class RunLabyrinth {
    //地图
    static int[][] map = null;
    //保存走过的路，数组d的元素表示当前走了多少步
    //当没有走过的话，则该值为0
    static int[][] d = null;

    //用于记录当前位置是从之前哪个位置过来的，便于输出路径
    static Pair[][] prev = null;

    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String[] nums = br.readLine().split(" ");

        n = Integer.parseInt(nums[0]);
        m = Integer.parseInt(nums[1]);

        map = new int[n][m];
        d = new int[n][m];
        prev = new Pair[n][m];


        //迷宫map
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        System.out.println(bfs());

    }

    public static int bfs() {
        //初始化队列
        Queue<Pair> q = new LinkedList<Pair>();


        int[] dy = {0, 1, 0, -1}, dx = {-1, 0, 1, 0};
        //加入起点0, 0
        q.offer(new Pair(0, 0));

        while (!q.isEmpty()) {
            Pair pair = q.poll();
            if (pair.x == n - 1 && pair.y == m - 1) {
                break;
            }

            //上左下右 遍历
            for (int i = 0; i < 4; i++) {
                int x = pair.x + dx[i];
                int y = pair.y + dy[i];
                if (x >= 0 && x < n && y >= 0 && y < m && map[x][y] == 0 && d[x][y] == 0) {
                    q.offer(new Pair(x, y));
                    d[x][y] = d[pair.x][pair.y] + 1;
                    //存储能到当前x,y的位置
//                    System.out.println("x:"+x+" y:"+y);
                    prev[x][y] = pair;
                }
            }
        }

        //从终点往前遍历到起点
        int x = n - 1, y = m - 1;
        while (x != 0 || y != 0) {
            System.out.println(x + " " + y);
            //prev[x][y] 存储的是能到达当前位置的位置
            Pair tmp = prev[x][y];
            x = tmp.x;
            y = tmp.y;
        }

        return d[n - 1][m - 1];
    }
}
