// 220. Contains Duplicate III
//You are given an integer array nums and two integers indexDiff and valueDiff.

// Find a pair of indices(i,j)such that:
// i!=j, abs(i-j)<=indexDiff, abs(nums[i]-nums[j])<=valueDiff, and Return true if such pair exists or false otherwise.

import java.util.*;

public class Contains_Duplicate_III {

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        // TreeSet to maintain a sorted window of at most `indexDiff` elements
        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            long num = (long) nums[i];

            // Check for the smallest number >= (num - valueDiff)
            Long floor = set.floor(num + valueDiff);
            if (floor != null && floor >= num - valueDiff) {
                return true;
            }

            // Add the current number to the set
            set.add(num);

            // Maintain the window size, so if it's exceeded, remove the oldest element
            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        int indexDiff = 3;
        int valueDiff = 0;

        System.out.println(containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff)); // true
    }
}
