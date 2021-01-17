package leetcode;
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int res = 0;
        int m = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int[][] clone = matrix.clone();
                for (int k = 0; k < matrix.length; k++) {
                    int temp = matrix[k][i];
                    matrix[k][i] = matrix[k][j];
                    matrix[k][j] = temp;

                }
                res = Math.max(maximalSquare(matrix), res);
                matrix = clone;
            }

        }
        return 1;
    }

        public int maximalSquare(int[][] matrix) {
            int maxSide = 0;
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return maxSide;
            }
            int rows = matrix.length, columns = matrix[0].length;
            int[][] dp = new int[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (matrix[i][j] == 1) {
                        if (i == 0 || j == 0) {
                            dp[i][j] = 1;
                        } else {
                            dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                        }
                        maxSide = Math.max(maxSide, dp[i][j]);
                    }
                }
            }
            int maxSquare = maxSide * maxSide;
            return maxSquare;
        }


    }