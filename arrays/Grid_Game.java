//2017. Grid Game

//You are given a 0-indexed 2D array grid of size 2 x n, where grid[r][c] represents the number of points at position (r, c) on the matrix. 
//Two robots are playing a game on this matrix.
// Both robots initially start at (0, 0) and want to reach (1, n-1). 
//Each robot may only move to the right ((r, c) to (r, c + 1)) or down ((r, c) to (r + 1, c)).
// At the start of the game, the first robot moves from (0, 0) to (1, n-1), collecting all the points from the cells on its path. 
//For all cells (r, c) traversed on the path, grid[r][c] is set to 0. 
//Then, the second robot moves from (0, 0) to (1, n-1), collecting the points on its path. Note that their paths may intersect with one another.
// The first robot wants to minimize the number of points collected by the second robot. 
//In contrast, the second robot wants to maximize the number of points it collects. 
//If both robots play optimally, return the number of points collected by the second robot.

public class Grid_Game {
    class Solution {
        public static long gridGame(int[][] grid) {
            long minResult = Long.MAX_VALUE;
            long row1Sum = 0;
            for (int i = 0; i < grid[0].length; ++i) {
                row1Sum += grid[0][i];
            }
            long row2Sum = 0;

            for (int i = 0; i < grid[0].length; ++i) {
                row1Sum -= grid[0][i];
                minResult = Math.min(minResult, Math.max(row1Sum, row2Sum));
                row2Sum += grid[1][i];
            }

            return minResult;
        }
    }

    public static void main(String[] args) {
        int[][] grid = { { 2, 5, 4 }, { 1, 5, 1 } };
        System.out.println(gridGame(grid));

        // Input: grid = [[2,5,4],[1,5,1]]
        // Output: 4
        // Explanation: The optimal path taken by the first robot is shown in red, and
        // the optimal path taken by the second robot is shown in blue.
        // The cells visited by the first robot are set to 0.
        // The second robot will collect 0 + 0 + 4 + 0 = 4 points.
    }
}
