//2461. Maximum Sum of Distinct Subarrays With Length K

// You are given an integer array nums and an integer k. 
//Find the maximum subarray sum of all the subarrays of nums that meet the following conditions:
// The length of the subarray is k, and All the elements of the subarray are distinct.
// Return the maximum subarray sum of all the subarrays that meet the conditions. 
//If no subarray meets the conditions, return 0.
// A subarray is a contiguous non-empty sequence of elements within an array.

import java.util.HashSet;

public class Maximum_Sum_Of_SubArrays_With_K_Elemets {

    public static long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long maxSum = 0;
        long currentSum = 0;
        HashSet<Integer> uniqueElements = new HashSet<>();

        int left = 0;

        for (int right = 0; right < n; right++) {
            currentSum += nums[right];

            while (uniqueElements.contains(nums[right])) {
                currentSum -= nums[left];
                uniqueElements.remove(nums[left]);
                left++;
            }

            uniqueElements.add(nums[right]);

            if (right - left + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);

                currentSum -= nums[left];
                uniqueElements.remove(nums[left]);
                left++;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 5, 4, 2, 9, 9, 9 };
        int k = 3;

        System.out.println(maximumSubarraySum(nums, k)); // 15

    }
}

// Explanation: The subarrays of nums with length 3 are:
// - [1,5,4] which meets the requirements and has a sum of 10.
// - [5,4,2] which meets the requirements and has a sum of 11.
// - [4,2,9] which meets the requirements and has a sum of 15.
// - [2,9,9] which does not meet the requirements because the element 9 is
// repeated.
// - [9,9,9] which does not meet the requirements because the element 9 is
// repeated.
// We return 15 because it is the maximum subarray sum of all the subarrays that
// meet the conditions