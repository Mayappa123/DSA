//2658. Maximum Number of Fish in a Grid

// You are given a 0-indexed 2D matrix grid of size m x n, where (r, c) represents:
// A land cell if grid[r][c] = 0, or
// A water cell containing grid[r][c] fish, if grid[r][c] > 0.
// A fisher can start at any water cell (r, c) and can do the following operations any number of times:
// Catch all the fish at cell (r, c), or
// Move to any adjacent water cell.

// Return the maximum number of fish the fisher can catch if he chooses his starting cell optimally, or 0 if no water cell exists.
// An adjacent cell of the cell (r, c), is one of the cells (r, c + 1), (r, c - 1), (r + 1, c) or (r - 1, c) if it exists.

public class Maximum_Number_of_Fish_in_Grid {

    public static int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
    public static boolean[][] visited;

    public static int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxFish = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    continue;

                visited = new boolean[m][n];

                maxFish = Math.max(maxFish, dfs(grid, i, j, m, n));
            }
        }

        return maxFish;
    }

    public static int dfs(int[][] grid, int i, int j, int m, int n) {
        visited[i][j] = true;
        int fish = 0;

        if (grid[i][j] == 0)
            return fish;

        fish += grid[i][j];
        for (int[] dir : directions) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                if (!visited[nr][nc]) {
                    fish += dfs(grid, nr, nc, m, n);
                }
            }
        }

        return fish;
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 2, 1, 0 }, { 4, 0, 0, 3 }, { 1, 0, 0, 4 }, { 0, 3, 2, 0 } };

        System.out.println(findMaxFish(grid));

        // Input: grid = [[0,2,1,0],[4,0,0,3],[1,0,0,4],[0,3,2,0]]
        // Output: 7
        // Explanation: The fisher can start at cell (1,3) and collect 3 fish, then move
        // to cell (2,3) and collect 4 fish.
    }
}