//2257. Count Unguarded Cells in the Grid

// You are given two integers m and n representing a 0-indexed m x n grid.
//You are also given two 2D integer arrays guards and walls where 
//guards[i]=[rowi,coli] and walls[j]=[rowj,colj] represent the positions of the ith guard and jth wall respectively.

// A guard can see every cell in the four cardinal directions(north,east,south,or west)starting from their position unless obstructed by a wall or another guard.
//A cell is guarded if there is at least one guard that can see it.

// Return the number of unoccupied cells that are not guarded.

public class Count_Unguarded_Cells_in_Matrix {

    public static int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        // Create a grid to represent the positions of guards, walls, and guarded cells
        char[][] grid = new char[m][n];

        // Mark guards and walls in the grid
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 'G'; // Guard
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 'W'; // Wall
        }

        // Mark guarded cells
        for (int[] guard : guards) {
            int row = guard[0];
            int col = guard[1];

            // Mark all cells north of the guard until a wall or another guard is
            // encountered
            for (int r = row - 1; r >= 0; r--) {
                if (grid[r][col] == 'W' || grid[r][col] == 'G') {
                    break;
                }
                if (grid[r][col] == 0) {
                    grid[r][col] = 'X';
                }
            }

            // Mark all cells south of the guard until a wall or another guard is
            // encountered
            for (int r = row + 1; r < m; r++) {
                if (grid[r][col] == 'W' || grid[r][col] == 'G') {
                    break;
                }
                if (grid[r][col] == 0) {
                    grid[r][col] = 'X';
                }
            }

            // Mark all cells west of the guard until a wall or another guard is encountered
            for (int c = col - 1; c >= 0; c--) {
                if (grid[row][c] == 'W' || grid[row][c] == 'G') {
                    break;
                }
                if (grid[row][c] == 0) {
                    grid[row][c] = 'X';
                }
            }

            // Mark all cells east of the guard until a wall or another guard is encountered
            for (int c = col + 1; c < n; c++) {
                if (grid[row][c] == 'W' || grid[row][c] == 'G') {
                    break;
                }
                if (grid[row][c] == 0) {
                    grid[row][c] = 'X';
                }
            }
        }

        // Count unoccupied and unguarded cells
        int unguardedCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    unguardedCount++;
                }
            }
        }

        return unguardedCount;
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 6;
        int[][] guards = { { 0, 0 }, { 1, 1 }, { 2, 3 } };
        int[][] walls = { { 0, 1 }, { 2, 2 }, { 1, 4 } };

        int result = countUnguarded(m, n, guards, walls);

        System.out.println("Number of unguarded cells: " + result); // 7

        // { G, W, 0, 1, 0, 0}
        // { 1, G, 1, 1, W, 0}
        // { 1, 1, W, G, 1, 1}
        // { 1, 1, 0, 1, 0, 0}
    }

}