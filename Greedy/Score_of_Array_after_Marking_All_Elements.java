//2593. Find Score of an Array After Marking All Elements

// You are given an array nums consisting of positive integers.
// Starting with score = 0, apply the following algorithm:
// Choose the smallest integer of the array that is not marked. If there is a tie, choose the one with the smallest index.
// Add the value of the chosen integer to score.
// Mark the chosen element and its two adjacent elements if they exist.
// Repeat until all the array elements are marked.
// Return the score you get after applying the above algorithm.

import java.util.*;
public class Score_of_Array_after_Marking_All_Elements {

    public static long findScore(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {
            dp[i][0] = nums[i];
            dp[i][1] = i;
        }

        Arrays.sort(dp, (a, b) -> a[0] - b[0]);

        boolean[] marked = new boolean[n];
        long result = 0;

        for (int[] arr : dp) {
            int val = arr[0];
            int ind = arr[1];

            if (!marked[ind]) {
                result += val;

                marked[ind] = true;
                if (ind > 0)
                    marked[ind - 1] = true;
                if (ind < n - 1) 
                    marked[ind + 1] = true;
            }
        }

        return result;
    }

    public static void main (String[] args) {
       int[] nums = {2,1,3,4,5,2};

       System.out.println(findScore(nums));  //7

        // Explanation: We mark the elements as follows:
        //     1 is the smallest unmarked element, so we mark it and its two adjacent elements: [2,1,3,4,5,2].
        //     2 is the smallest unmarked element, so we mark it and its left adjacent element: [2,1,3,4,5,2].
        //     4 is the only remaining unmarked element, so we mark it: [2,1,3,4,5,2].
        //     Our score is 1 + 2 + 4 = 7.
    }
}