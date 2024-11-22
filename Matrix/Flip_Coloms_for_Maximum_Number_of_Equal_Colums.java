//1072. Flip Columns For Maximum Number of Equal Rows

//You are given an m x n binary matrix matrix.
//You can choose any number of columns in the matrix and flip every cell in that column (i.e., Change the value of the cell from 0 to 1 or vice versa).
//Return the maximum number of rows that have all values equal after some number of flips.

// Example 1:
// Input: matrix = [[0,1],[1,1]]
// Output: 1
// Explanation: After flipping no values, 1 row has all values equal.

// Example 2:
// Input: matrix = [[0,1],[1,0]]
// Output: 2
// Explanation: After flipping values in the first column, both rows have equal values.

// Example 3:
// Input: matrix = [[0,0,0],[0,0,1],[1,1,0]]
// Output: 2
// Explanation: After flipping values in the first two columns, the last two rows have equal values.

import java.util.*;

public class Flip_Coloms_for_Maximum_Number_of_Equal_Colums {

    public static int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> patternCount = new HashMap<>();

        for (int[] row : matrix) {
            StringBuilder pattern = new StringBuilder();
            StringBuilder complement = new StringBuilder();

            // Build the pattern and its complement
            for (int cell : row) {
                pattern.append(cell);
                complement.append(1 - cell); // Flip 0 -> 1 and 1 -> 0
            }

            // Use the pattern that starts with '0' as the key
            String key = pattern.charAt(0) == '0' ? pattern.toString() : complement.toString();

            patternCount.put(key, patternCount.getOrDefault(key, 0) + 1);
        }

        // Find the maximum count of any pattern
        int maxRows = 0;
        for (int count : patternCount.values()) {
            maxRows = Math.max(maxRows, count);
        }

        return maxRows;
    }

    public static void main(String[] args) {

        int[][] matrix = { { 0, 0, 0 }, { 0, 0, 1 }, { 1, 1, 0 } };

        int ans = maxEqualRowsAfterFlips(matrix);
        System.out.println(ans); // 3

    }
}
