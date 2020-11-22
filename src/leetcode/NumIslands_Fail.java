package leetcode;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumIslands_Fail {


    static final int N = 310;

    static int[][] p = new int[N][N];

    static boolean[][] st = new boolean[N][N];

    static Node[][] f = new Node[N][N];

    private static Node find(Node k) {

        if ((f[k.x][k.y].x == k.x) && (f[k.x][k.y].y == k.y)) return k;
        return find(f[k.x][k.y]);

//        if(p[i][j]>0) p[i][j]=find(i, j);
//
//        return p[i][j];
    }


    public static int numIslands(char[][] grid) {

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                f[i][j] = new Node(i, j, -1);
            }
        }

        int countP = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    f[i][j] = new Node(i, j, ++countP);
                }
            }
        }
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x < grid.length && y < grid[i].length && x >= 0 && y >= 0 && grid[x][y] == '1') {
                            st[i][j] = true;
                            p[i][j] = find(new Node(x, y, 0)).v;

                        }
                    }
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (p[i][j] != -1) {
                    set.add(p[i][j]);
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            System.out.println();
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(p[i][j] + " ");
            }
        }


        return set.size();

    }


    public static void main(String[] args) {
        char[][] a = new char[][]{{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};

//        numIslands(a);

//        System.out.println(find(1,0));
        System.out.println(numIslands(a));
    }


}

class Node {
    int x;
    int y;
    int v;

    Node(int x, int y, int v) {
        this.x = x;
        this.y = y;
        this.v = v;
    }
}