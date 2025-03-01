//2044. Count Number of Maximum Bitwise-OR Subsets

public class LeetCode_2044 {
    public static int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for (int i : nums) {
            maxOr |= i;
        }
        return solve(0, nums, 0, maxOr);
    }

    private static int solve(int i, int[] nums, int or, int maxOr) {
        if (i == nums.length) {
            if (or == maxOr) {
                return 1;
            }
            return 0;
        }

        int ans = 0;

        // Include
        ans += solve(i + 1, nums, or | nums[i], maxOr);

        // Don't include
        ans += solve(i + 1, nums, or, maxOr);
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 5 };

        System.out.println(countMaxOrSubsets(nums));
    }
}

// Input:nums=[3,1]
// Output:2 Explanation:

// The maximum possible bitwise OR of a subset is 3.
// There are 2 subsets with a bitwise

// OR of 3:-[3]-[3,1]

