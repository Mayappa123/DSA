//2657. Find the Prefix Common Array of Two Arrays

//You are given two 0-indexed integer permutations A and B of length n.
// A prefix common array of A and B is an array C such that C[i] is equal to the count of numbers that are present at or before the index i in both A and B.
// Return the prefix common array of A and B.
// A sequence of n integers is called a permutation if it contains all integers from 1 to n exactly once.

public class Prefix_Common_Array_of_Two_Arrays {
    public static int[] findThePrefixCommonArray(int[] A, int[] B) {
        int a[] = new int[51];
        int len = A.length;
        int res[] = new int[len];
        for (int i = 1; i <= len; i++) {
            a[A[i - 1]]++;
            a[B[i - 1]]++;
            int count = 0;
            for (int j = 0; j <= 50; j++) {
                if (a[j] == 2) {
                    count++;
                }
            }
            res[i - 1] = count;
        }
        return res;
    }

    public static void main(String[] args) {
        int A = { 1, 3, 2, 4 }, B = { 3, 1, 2, 4 };
        System.out.println(findThePrefixCommonArray(A, B));

        // Input: A = [1,3,2,4], B = [3,1,2,4]
        // Output: [0,2,3,4]
        // Explanation: At i = 0: no number is common, so C[0] = 0.
        // At i = 1: 1 and 3 are common in A and B, so C[1] = 2.
        // At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.
        // At i = 3: 1, 2, 3, and 4 are common in A and B, so C[3] = 4.

    }
}
