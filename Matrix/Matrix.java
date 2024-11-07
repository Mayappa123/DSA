public class Matrix {

    public static void printMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        System.out.println("Rows = " + m);
        System.out.println("Colomns = " + n);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();
        }

    }

    public static void printMatrixWithRowSums(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
                rowSum += matrix[i][j];
            }
            System.out.println(rowSum);
        }
    }

    public static void printColumnSums(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int j = 0; j < n; j++) {
            int colSum = 0;
            for (int i = 0; i < m; i++) {
                colSum += matrix[i][j];
            }
            System.out.print(colSum + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };

        printMatrix(matrix);

        System.out.println("Matrix with row sums:");
        printMatrixWithRowSums(matrix);

        System.out.println("Column sums:");
        printColumnSums(matrix);
    }
}