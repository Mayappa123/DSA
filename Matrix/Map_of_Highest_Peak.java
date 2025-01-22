//1765. Map of Highest Peak

//You are given an integer matrix isWater of size m x n that represents a map of land and water cells.
// If isWater[i][j]==0,cell(i,j)is a land cell.If isWater[i][j]==1,cell(i,j)is a water cell.
//You must assign each cell a height in a way that follows these rules:
// The height of each cell must be non-negative.If the cell is a water cell,its height must be 0. 
//Any two adjacent cells must have an absolute height difference of at most 1. 
//A cell is adjacent to another cell if the former is directly north,east,south,or west of the latter(i.e.,their sides are touching).

//Find an assignment of heights such that the maximum height in the matrix is maximized.
// Return an integer matrix height of size m x n where height[i][j]is cell(i,j)'sheight.
//If there are multiple solutions,return any of them.

import java.util.LinkedList;

public class Map_of_Highest_Peak {
    public static int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] height = new int[m][n];
        Queue<int[]> q = new LinkedList<>();

        // Initialize water cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                height[i][j] = -1;
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                    q.offer(new int[] { i, j });
                }
            }
        }

        // BFS directions
        int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        // BFS from water to land
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && height[nx][ny] == -1) {
                    height[nx][ny] = height[x][y] + 1;
                    q.offer(new int[] { nx, ny });
                }
            }
        }
        return height;
    }

    public static void main(String[] args) {

        int[][] isWater = { { 0, 1 }, { 0, 0 } };
        System.out.println(Integer.toString(highestPeak(isWater)));

        // Input: isWater = [[0,1],[0,0]]
        // Output: [[1,0],[2,1]]
        // Explanation: The image shows the assigned heights of each cell.
        // The blue cell is the water cell, and the green cells are the land cells.
    }
}
