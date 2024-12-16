//3264. Final Array State After K Multiplication Operations I

// You are given an integer array nums, an integer k, and an integer multiplier.
// You need to perform k operations on nums. In each operation:
// Find the minimum value x in nums. 
//If there are multiple occurrences of the minimum value, select the one that appears first.
// Replace the selected minimum value x with x * multiplier.
// Return an integer array denoting the final state of nums after performing all k operations.

import java.util.*;

public class Final_Array_State_after_K_Multiplication_Operation {

    public static int[] getFinalState(int[] nums, int k, int multiplier) {
        for (int i = 0; i < k; i++) {
            int min = 0;

            for (int j = 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            nums[min] *= multiplier;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 1, 3, 5, 6 };
        int k = 5;
        int multiplier = 2;

        System.out.println(Arrays.toString(getFinalState(nums, k, multiplier))); // [8,4,6,5,6]

    }
}
