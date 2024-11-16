//3254. Find the Power of K-Size Subarrays I
//You are given an array of integers nums of length n and a positive integer k.

// The power of an array is defined as:

// Its maximum element if all of its elements are consecutive and sorted in ascending order.
// -1 otherwise.
// You need to find the power of all 
// subarrays
//  of nums of size k.

// Return an integer array results of size n - k + 1, where results[i] is the power of nums[i..(i + k - 1)].

import java.util.*;

public class Find_Power_of_KSize_SubArrays {

    public static int[] resultsArray(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i <= n - k; i++) {
            boolean isConsecutive = true;
            int maxVal = nums[i];

            for (int j = i; j < i + k - 1; j++) {
                if (nums[j] + 1 != nums[j + 1]) {
                    isConsecutive = false;
                    break;
                }
                maxVal = Math.max(maxVal, nums[j + 1]);
            }

            ans.add(isConsecutive ? maxVal : -1);
        }

        // Convert List<Integer> to int[]
        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 4, 3, 2, 5 };
        int k = 3;

        System.out.println(Arrays.toString(resultsArray(nums, k))); // [3, 4, -1, -1, -1]

    }
}
