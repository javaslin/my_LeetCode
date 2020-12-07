package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SetZeros {


    public void setZeroes(int[][] matrix) {


        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> filterI = new ArrayList<>();
        List<Integer> fileterJ = new ArrayList<>();


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    filterI.add(i);
                    fileterJ.add(j);
                }
            }
        }

        for (int i = 0; i < m && filterI.contains(i); i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;
            }
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n && fileterJ.contains(j); j++) {
                matrix[i][j] = 0;
            }
        }


    }
}
