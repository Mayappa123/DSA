// 407. Trapping Rain Water II

// Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation map, 
//Return the volume of water it can trap after raining.

public class Trapping_rainwater_II {
    public static int trapRainWater(int[][] heightMap) {
        int m = heightMap.length; // Grid rows
        int n = heightMap[0].length; // Grid columns

        // Step 1: Initialize volumes with terrain heights
        int[][] vols = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                vols[i][j] = heightMap[i][j];
            }
        }

        // Step 2: Iterative spreading to enforce constraints
        boolean upt = true;
        boolean init = true;
        while (upt) {
            upt = false;

            // Pass 1: Spread constraints from top-left to bottom-right
            for (int i = 1; i < m - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    int val = Math.max(heightMap[i][j],
                            Math.min(vols[i - 1][j], vols[i][j - 1]));
                    if (init || vols[i][j] > val) {
                        vols[i][j] = val;
                        upt = true;
                    }
                }
            }
            init = false;

            // Pass 2: Spread constraints from bottom-right to top-left
            for (int i = m - 2; i >= 1; i--) {
                for (int j = n - 2; j >= 1; j--) {
                    int val = Math.max(heightMap[i][j],
                            Math.min(vols[i + 1][j], vols[i][j + 1]));
                    if (vols[i][j] > val) {
                        vols[i][j] = val;
                        upt = true;
                    }
                }
            }
        }

        // Step 3: Calculate total trapped water
        int res = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (vols[i][j] > heightMap[i][j])
                    res += vols[i][j] - heightMap[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] heightMap = { { 1, 4, 3, 1, 3, 2 }, { 3, 2, 1, 3, 2, 4 }, { 2, 3, 3, 2, 3, 1 } };
        System.out.println(trapRainWater(heightMap));

        // Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
        // Output: 4
        // Explanation: After the rain, water is trapped between the blocks.
        // We have two small ponds 1 and 3 units trapped.
        // The total volume of water trapped is 4.
    }
}