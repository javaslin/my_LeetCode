package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] st = new boolean[n][m];


        List<Integer> ans = new ArrayList<>();

        if (n == 0) {
            return ans;
        }

        int ini = 0;

        int x = 0, y = 0;
        while (ini != n * m) {

            //向右
            while (y < m && !st[x][y]) {
                ans.add(matrix[x][y]);
                st[x][y] = true;
                System.out.println(x + " " + y);
                y++;
                ini++;

            }
            System.out.println("-----");
            //向下
            while (x + 1 < n && !st[x + 1][y - 1]) {
                ans.add(matrix[x + 1][y - 1]);
                st[x + 1][y - 1] = true;
                System.out.println((x + 1) + " " + (y - 1));
                x++;
                ini++;

            }

            System.out.println("-----");
            //向左
            while (y - 2 >= 0 && !st[x][y - 2]) {
                ans.add(matrix[x][y - 2]);
                st[x][y - 2] = true;
                System.out.println(x + " " + (y - 2));
                y--;
                ini++;


            }
            System.out.println("-----");

            //向上
            while (x - 1 >= 0 && !st[x - 1][y - 1]) {

                ans.add(matrix[x - 1][y - 1]);
                st[x - 1][y - 1] = true;
                System.out.println((x - 1) + " " + (y - 1));
                x--;
                ini++;

            }
            System.out.println("-----");
        }

        return ans;


    }
}
