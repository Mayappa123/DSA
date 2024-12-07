//1760. Minimum Limit of Balls in a Bag


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
        int[] nums = {9};
        int maxOperations = 2;

        System.out.println(minimumSize(nums, maxOperations));
    }
}
