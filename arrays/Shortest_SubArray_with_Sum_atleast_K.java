//862. Shortest Subarray with Sum at Least K

// Given an integer array nums and an integer k, return the length of the shortest non-empty subarray of nums with a sum of at least k. 
//If there is no such subarray, return -1.

// A subarray is a contiguous part of an array.

import java.util.*;

public class Shortest_SubArray_with_Sum_atleast_K {

    public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];

        // Compute the prefix sum
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int minLength = Integer.MAX_VALUE;
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < prefixSum.length; i++) {
            // Remove elements from the front if the subarray sum is >= k
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
                minLength = Math.min(minLength, i - deque.pollFirst());
            }

            // Maintain monotonic property of the deque
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(i);
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static void main(String[] args) {

        int[] nums = { 2, -1, 2 };
        int k = 3;

        System.out.println(shortestSubarray(nums, k)); //3

    }
}
