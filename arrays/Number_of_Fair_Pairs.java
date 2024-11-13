//2563. Count the Number of Fair Pairs

//2563. Count the Number of Fair Pairs

// Given a 0-indexed integer array nums of size n and two integers lower and upper, return the number of fair pairs.

// A pair (i, j) is fair if:

// 0 <= i < j < n, and
// lower <= nums[i] + nums[j] <= upper

import java.util.*;

public class Number_of_Fair_Pairs {

    public static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int low = lowerBound(nums, i + 1, nums.length, lower - nums[i]);
            int up = upperBound(nums, i + 1, nums.length, upper - nums[i]);
            ans += up - low;
        }
        return ans;
    }

    private static int lowerBound(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target)
                end = mid;
            else
                start = mid + 1;
        }
        System.out.print("lowerBound " + start + " ");

        return start;
    }

    private static int upperBound(int[] nums, int start, int end, int target) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target)
                end = mid;
            else
                start = mid + 1;
        }
        System.out.println("upperBound " + start + " ");
        return start;

    }

    public static void main(String[] args) {
        int upper = 6, lower = 3;
        int[] nums = { 0, 1, 7, 4, 4, 5 };

        System.out.println(countFairPairs(nums, lower, upper)); // 6
    }
}
