// You are given a 0-indexed m x n matrix grid consisting of positive integers.

// You can start at any cell in the first column of the matrix, and traverse the grid in the following way:

// From a cell (row, col), you can move to any of the cells: (row - 1, col + 1), (row, col + 1) and (row + 1, col + 1) such that the value of the cell you move to, should be strictly bigger than the value of the current cell.
// Return the maximum number of moves that you can perform.

import java.util.*;

public class Max_Moves_in_Grid {
    public static int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        int max = 0;

        for (int j = 1; j < n; j++) {
            for (int i = 0; i < m; i++) {
                int upperDiagonal = 0, right = 0, lowerDiagonal = 0;

                if (i > 0 && grid[i][j] > grid[i - 1][j - 1]) {
                    upperDiagonal = dp[i - 1][j - 1];
                }
                if (i < m - 1 && grid[i][j] > grid[i + 1][j - 1]) {
                    lowerDiagonal = dp[i + 1][j - 1];
                }
                if (grid[i][j] > grid[i][j - 1]) {
                    right = dp[i][j - 1];
                }

                int res = Math.max(Math.max(right, lowerDiagonal), upperDiagonal);
                dp[i][j] = (res == 0) ? 0 : res + 1;
                max = Math.max(max, dp[i][j]);
            }
        }
        return max == 0 ? 0 : max - 1;
    }

    public static void main(String[] args) {
        int[][] grid = { { 2, 4, 3, 5 }, { 5, 4, 9, 3 }, { 3, 4, 2, 11 }, { 10, 9, 13, 15 } };

        System.out.println("Maximum Moves : " + maxMoves(grid)); // 3

    }
}