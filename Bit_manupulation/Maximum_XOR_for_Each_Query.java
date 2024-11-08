//1829. Maximum XOR for Each Query

// You are given a sorted array nums of n non-negative integers and an integer maximumBit. You want to perform the following query n times:

// Find a non-negative integer k < 2maximumBit such that nums[0] XOR nums[1] XOR ... XOR nums[nums.length-1] XOR k is maximized. k is the answer to the ith query.
// Remove the last element from the current array nums.
// Return an array answer, where answer[i] is the answer to the ith query.

public class Maximum_XOR_for_Each_Query {

    public static int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int max_xor_value = (1 << maximumBit) - 1; // This is 2^maximumBit - 1, with all bits set within the range.
        int[] result = new int[n];

        int prefix_xor = 0;

        // Step 1: Calculate the cumulative XOR of the entire array initially
        for (int num : nums) {
            prefix_xor ^= num;
        }

        // Step 2: Process each query from the end of the array
        for (int i = 0; i < n; i++) {
            // Calculate the maximum k for the current prefix_xor
            result[i] = prefix_xor ^ max_xor_value;

            // Update prefix_xor by removing the last element (nums[n - 1 - i])
            prefix_xor ^= nums[n - 1 - i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 1, 3 };
        int maximumBit = 2;
        int[] result = getMaximumXor(nums, maximumBit); // Store the result here

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " "); // 0 3 2 3
        }

    }
}