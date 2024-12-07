//1760. Minimum Limit of Balls in a Bag

// You are given an integer array nums where the ith bag contains nums[i] balls. You are also given an integer maxOperations.
// You can perform the following operation at most maxOperations times:
// Take any bag of balls and divide it into two new bags with a positive number of balls.
// For example, a bag of 5 balls can become two new bags of 1 and 4 balls, or two new bags of 2 and 3 balls.
// Your penalty is the maximum number of balls in a bag. You want to minimize your penalty after the operations.
// Return the minimum possible penalty after performing the operations.

public class Minimum_Limit_of_Balls_in_Bag {

    public static int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = 0;

        // Find the maximum value in nums to define the search space
        for (int num : nums) {
            right = Math.max(right, num);
        }

        // Perform binary search
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canReduce(nums, maxOperations, mid)) {
                right = mid; // Try for a smaller penalty
            } else {
                left = mid + 1; // Increase the penalty
            }
        }

        return left; // The minimum penalty
    }

    private static boolean canReduce(int[] nums, int maxOperations, int penalty) {
        int operations = 0;

        for (int num : nums) {
            // Calculate the required operations for this bag
            if (num > penalty) {
                operations += (num - 1) / penalty; // Integer division gives the splits needed
            }
        }

        return operations <= maxOperations;
    }

    public static void main(String[] args) {
        int[] nums = { 9 };
        int maxOperations = 2;

        System.out.println(minimumSize(nums, maxOperations)); // 3

        // Input: nums = [9], maxOperations = 2
        // Output: 3
        // Explanation:
        // - Divide the bag with 9 balls into two bags of sizes 6 and 3. [9] -> [6,3].
        // - Divide the bag with 6 balls into two bags of sizes 3 and 3. [6,3] ->
        // [3,3,3].
        // The bag with the most number of balls has 3 balls, so your penalty is 3 and
        // you should return 3.

    }
}
