package Arrays;

import java.util.Arrays;
// Find missing number in an array.

public class Find_Missing_Number {
    public static int missingnumber (int[] arr) {
        int n = arr.length;
        int m = n + 1;int total = m * (m + 1)/ 2;
        int sum = Arrays.stream(arr).sum();
        return total - sum;
    }
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 7, 8, 9, 10};
        System.out.println("Missing number in an array is "+missingnumber(arr));
        
    }
    
}
