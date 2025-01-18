//1368. Minimum Cost to Make at Least One Valid Path in a Grid

// Given an m x n grid. Each cell of the grid has a sign pointing to the next cell you should visit if you are currently in this cell. 
//The sign of grid[i][j] can be:
// 1 which means go to the cell to the right. (i.e go from grid[i][j] to grid[i][j + 1])
// 2 which means go to the cell to the left. (i.e go from grid[i][j] to grid[i][j - 1])
// 3 which means go to the lower cell. (i.e go from grid[i][j] to grid[i + 1][j])
// 4 which means go to the upper cell. (i.e go from grid[i][j] to grid[i - 1][j])
// Notice that there could be some signs on the cells of the grid that point outside the grid.
// You will initially start at the upper left cell (0, 0). A valid path in the grid is a path that starts from the upper left cell (0, 0) and ends at the bottom-right cell (m - 1, n - 1) following the signs on the grid. 
//The valid path does not have to be the shortest.
// You can modify the sign on a cell with cost = 1. You can modify the sign on a cell one time only.
// Return the minimum cost to make the grid have at least one valid path.

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Minimum_Cost_to_Make_at_Least_One_Valid_Path_in_a_Grid {
    public static int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] minCost = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(minCost[i], Integer.MAX_VALUE);
        }

        Deque<int[]> dque = new ArrayDeque<>();
        dque.offerFirst(new int[] { 0, 0 });
        minCost[0][0] = 0;

        int[][] direction = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        while (!dque.isEmpty()) {
            int[] arr = dque.pollFirst();
            int r = arr[0];
            int c = arr[1];

            // Visited adjacent cells
            for (int i = 0; i < 4; i++) {
                int nr = r + direction[i][0];
                int nc = c + direction[i][1];
                int cost = (grid[r][c] != (i + 1)) ? 1 : 0;

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && minCost[r][c] + cost < minCost[nr][nc]) {
                    minCost[nr][nc] = minCost[r][c] + cost;

                    if (cost == 1) {
                        dque.offerLast(new int[] { nr, nc });
                    } else {
                        dque.offerFirst(new int[] { nr, nc });
                    }
                }
            }
        }

        return minCost[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 1, 1, 1 }, { 2, 2, 2, 2 }, { 1, 1, 1, 1 }, { 2, 2, 2, 2 } };
        System.out.println(minCost(grid));
        
        // Input: grid = [[1,1,1,1],[2,2,2,2],[1,1,1,1],[2,2,2,2]]
        // Output: 3
        // Explanation: You will start at point (0, 0).
        // The path to (3, 3) is as follows. (0, 0) --> (0, 1) --> (0, 2) --> (0, 3)
        // change the arrow to down with cost = 1 --> (1, 3) --> (1, 2) --> (1, 1) -->
        // (1, 0) change the arrow to down with cost = 1 --> (2, 0) --> (2, 1) --> (2,
        // 2) --> (2, 3) change the arrow to down with cost = 1 --> (3, 3)
        // The total cost = 3.
    }
}