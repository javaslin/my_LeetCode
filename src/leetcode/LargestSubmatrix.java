package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestSubmatrix {

    public  int largestSubmatrix(int[][] matrix) {


        int n=matrix.length;
        int m=matrix[0].length;

        for (int i = 1; i < n; i ++ )
            for (int j = 0; j < m; j ++ )
                if (matrix[i][j]==1)
                    matrix[i][j] += matrix[i - 1][j];
        int res=0;

        Integer[] q=new Integer[m];
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <m ; j++) {
                q[j]=matrix[i][j];
            }
            Arrays.sort(q,(a,b)->b-a);
            for (int j = 0; j < m; j++) {
                res=Math.max(res,q[j]*(j+1));
            }

        }

        return res;
    }
}
