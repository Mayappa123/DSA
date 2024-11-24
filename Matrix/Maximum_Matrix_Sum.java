// 1975. Maximum Matrix Sum

// You are given an n x n integer matrix. 
//You can do the following operation any number of times:

// Choose any two adjacent elements of matrix and multiply each of them by -1.
// Two elements are considered adjacent if and only if they share a border.

// Your goal is to maximize the summation of the matrix's elements. 
// Return the maximum sum of the matrix's elements using the operation mentioned above.

public class Maximum_Matrix_Sum {

    public static long maxMatrixSum(int[][] matrix) {
        long totalSum = 0; // To store the absolute sum of all elements
        int negativeCount = 0; // Count of negative numbers
        int minAbsValue = Integer.MAX_VALUE; // Minimum absolute value in the matrix

        // Traverse the matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int value = matrix[i][j];
                totalSum += Math.abs(value); // Add the absolute value to the sum

                if (value < 0) {
                    negativeCount++; // Count negatives
                }

                minAbsValue = Math.min(minAbsValue, Math.abs(value)); // Track the smallest absolute value
            }
        }

        // If there's an odd number of negatives, subtract twice the smallest absolute
        // value
        if (negativeCount % 2 != 0) {
            totalSum -= 2 * minAbsValue;
        }

        return totalSum;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, -1 }, { -1, 1 } };

        System.out.println(maxMatrixSum(matrix)); //4
    }
}
