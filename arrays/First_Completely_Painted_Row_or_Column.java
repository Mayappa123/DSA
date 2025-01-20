// 2661. First Completely Painted Row or Column

// You are given a 0-indexed integer array arr, and an m x n integer matrix mat. arr and mat both contain all the integers in the range [1, m * n].
// Go through each index i in arr starting from index 0 and paint the cell in mat containing the integer arr[i].
// Return the smallest index i at which either a row or a column will be completely painted in mat.

import java.util.*;

public class First_Completely_Painted_Row_or_Column {
    public static int firstCompleteIndex(int[] arr, int[][] mat) {
        int rows = mat.length, cols = mat[0].length;
        Map<Integer, int[]> positionMap = new HashMap<>();
        int[] rowCount = new int[rows];
        int[] colCount = new int[cols];

        Arrays.fill(rowCount, cols);
        Arrays.fill(colCount, rows);

        for (int r = 0; r < rows; ++r) {
            for (int c = 0; c < cols; ++c) {
                positionMap.put(mat[r][c], new int[] { r, c });
            }
        }

        for (int idx = 0; idx < arr.length; ++idx) {
            int[] pos = positionMap.get(arr[idx]);
            if (--rowCount[pos[0]] == 0 || --colCount[pos[1]] == 0) {
                return idx;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 4 };
        int[][] mat = { { 1, 4 }, { 2, 3 } };
        System.out.println(firstCompleteIndex(arr, mat));

        // Input: arr = [1,3,4,2], mat = [[1,4],[2,3]]
        // Output: 2
        // Explanation: The moves are shown in order, and both the first row and second
        // column of the matrix become fully painted at arr[2].
    }
}
