
// You are given a 0-indexed 2D integer array grid of size m x n. 
//Each cell has one of two values:

// 0 represents an empty cell,
// 1 represents an obstacle that may be removed.
// You can move up, down, left, or right from and to an empty cell.

// Return the minimum number of obstacles to remove so you can move from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1).

import java.util.*;

class Minimum_Obstacle_Remove_to_Reach_Corner {
    public static int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n]; // Minimum cost to reach each cell

        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE); // Initialize to a large value
            dist[0][0] = 0;
        }

        // Deque for 0-1 BFS
        Deque<int[]> deque = new LinkedList<>();
        deque.addFirst(new int[] { 0, 0 }); // Start from the top-left corner

        // Directions for movement: up, down, left, right
        int[] dirX = { -1, 1, 0, 0 };
        int[] dirY = { 0, 0, -1, 1 };

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int x = current[0], y = current[1];

            // Explore neighbors
            for (int i = 0; i < 4; i++) {
                int nx = x + dirX[i];
                int ny = y + dirY[i];

                // Check if the neighbor is within bounds
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    // Calculate the new cost
                    int newCost = dist[x][y] + grid[nx][ny];
                    // Update if a cheaper cost is found
                    if (newCost < dist[nx][ny]) {
                        dist[nx][ny] = newCost;
                        if (grid[nx][ny] == 0) {
                            deque.addFirst(new int[] { nx, ny }); // Add to front for cost 0
                        } else {
                            deque.addLast(new int[] { nx, ny }); // Add to back for cost 1
                        }
                    }
                }
            }
        }

        // Return the minimum cost to reach the bottom-right corner
        return dist[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 1 }, { 1, 1, 0 }, { 1, 1, 0 } }; // 2

        System.out.println(minimumObstacles(grid));
    }
}

// Input: grid = [[0,1,1],[1,1,0],[1,1,0]]
// Output: 2

// Explanation: We can remove the obstacles at (0, 1) and (0, 2) to create a
// path from (0, 0) to (2, 2).
// It can be shown that we need to remove at least 2 obstacles, so we return 2.
// Note that there may be other ways to remove 2 obstacles to create a path.
