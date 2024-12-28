//689. Maximum Sum of 3 Non-Overlapping Subarrays

// Given an integer array nums and an integer k, find three non-overlapping subarrays of length k with maximum sum and return them.
// Return the result as a list of indices representing the starting position of each interval (0-indexed). 
//If there are multiple answers, return the lexicographically smallest one.

public class Maximum_Sum_of_3_Overlapping_Subarrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if (nums == null || nums.length < k * 3)
            return new int[] {};

        int numSub = nums.length - k + 1;

        int[] subSum = new int[numSub];
        int sum = 0;

        for (int i = 0; i < k; i++)
            sum += nums[i];

        subSum[0] = sum;

        for (int i = k; i < nums.length; i++) {
            sum -= nums[i - k];
            sum += nums[i];
            subSum[i - k + 1] = sum;
        }

        int[] maxAtLeft = new int[numSub];

        for (int i = 1; i < numSub; i++)
            maxAtLeft[i] = (subSum[i] > subSum[maxAtLeft[i - 1]]) ? i : maxAtLeft[i - 1];

        int[] maxAtRight = new int[numSub];
        maxAtRight[numSub - 1] = numSub - 1;

        for (int i = numSub - 2; i >= 0; i--)
            maxAtRight[i] = (subSum[i] >= subSum[maxAtRight[i + 1]]) ? i : maxAtRight[i + 1];

        int[] maxThree = new int[3];
        int maxSum = 0;
        for (int i = k; i < numSub - k; i++) {
            int curSum = subSum[maxAtLeft[i - k]] + subSum[i] + subSum[maxAtRight[i + k]];
            if (curSum > maxSum) {
                maxSum = curSum;
                maxThree = new int[] { maxAtLeft[i - k], i, maxAtRight[i + k] };
            }
        }
        return maxThree;
    }
}
