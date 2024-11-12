import java.util.*;

public class sort {

    public static int[][] sortArray(int[][] arr) {
        // Sort the array in-place based on the first element of each subarray
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        return arr; // Return the sorted array
    }

    public static void main(String[] args) {
        int[][] arr = { { 7, 1 }, { 1, 4 }, { 5, 6 }, { 3, 4 } };
        arr = sortArray(arr);

        // Print the sorted array
        for (int[] i : arr) {
            System.out.println(Arrays.toString(i));
        }
    }
}
