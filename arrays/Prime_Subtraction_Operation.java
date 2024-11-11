//2601. Prime Subtraction Operation

//You are given a 0-indexed integer array nums of length n.
// You can perform the following operation as many times as you want:
// Pick an index i that you haven’t picked before, and pick a prime p strictly less than nums[i], then subtract p from nums[i].
// Return true if you can make nums a strictly increasing array using the above operation and false otherwise.
// A strictly increasing array is an array whose each element is strictly greater than its preceding element.

public class Prime_Subtraction_Operation {

    private static boolean checkCondition(int[] nums) {
        int cnt = 0;
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                cnt++;
            }
        }
        return cnt == 0;
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        int val = (int) Math.sqrt(num);
        for (int i = 2; i <= val; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean primeSubOperation(int[] nums) {
        int n = nums.length;
        if (checkCondition(nums)) {
            return true;
        }

        for (int i = 0; i < n; i++) {
            int bound = (i == 0) ? nums[0] : nums[i] - nums[i - 1];
            if (bound <= 0) {
                return false;
            }

            int largestPrime = 0;
            for (int j = bound - 1; j >= 2; j--) {
                if (isPrime(j)) {
                    largestPrime = j;
                    break;
                }
            }

            if (largestPrime > 0) { // Check if a prime was found
                nums[i] -= largestPrime;
            }
        }

        return checkCondition(nums);
    }

    public static void main(String[] args) {
        int[] nums = { 4, 9, 6, 10 }; // true

        System.out.println(primeSubOperation(nums));

        // Explanation: In the first operation: Pick i = 0 and p = 3, and then subtract
        // 3 from nums[0], so that nums becomes [1,9,6,10].
        // In the second operation: i = 1, p = 7, subtract 7 from nums[1], so nums
        // becomes equal to [1,2,6,10].
        // After the second operation, nums is sorted in strictly increasing order, so
        // the answer is true.
    }
}
