//2577. Minimum Time to Visit a Cell In a Grid

// You are given a m x n matrix grid consisting of non-negative integers 
//where grid[row][col]represents the minimum time required to be able to visit the cell(row,col),
//which means you can visit the cell(row,col)only when the time you visit it is greater than or equal to grid[row][col].

// You are standing in the top-left cell of the matrix in the 0 th second,and 
//you must move to any adjacent cell in the four directions:up,down,left,and right
//.Each move you make takes 1 second.

// Return the minimum time required in which you can visit the bottom-right cell of the matrix.
//If you cannot visit the bottom-right cell,then return-1.

import java.util.*;

public class Minimum_Time_to_Visit_a_cell_in_Grid {

    private static final int[][] MOVES = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public static int minimumTime(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] seen = new boolean[rows][cols];

        pq.add(new int[] { 0, 0, 0 }); // time, row, col
        seen[0][0] = true;

        while (!pq.isEmpty()) {
            int[] curr = pq.remove();
            int time = curr[0];
            int row = curr[1];
            int col = curr[2];

            for (int[] dir : MOVES) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow < 0 || newRow >= rows ||
                        newCol < 0 || newCol >= cols ||
                        seen[newRow][newCol]) {
                    continue;
                }

                int newTime = time + 1;
                if (grid[newRow][newCol] > newTime) {
                    int wait = ((grid[newRow][newCol] - newTime + 1) / 2) * 2;
                    newTime += wait;
                }

                if (newRow == rows - 1 && newCol == cols - 1) {
                    return newTime;
                }

                seen[newRow][newCol] = true;
                pq.add(new int[] { newTime, newRow, newCol });
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[][] grid = { { 0, 1, 3, 2 }, { 5, 1, 2, 5 }, { 4, 3, 8, 6 } };

        System.out.println(minimumTime(grid));

    }
}
