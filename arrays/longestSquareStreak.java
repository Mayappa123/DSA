// You are given an integer array nums. A subsequence of nums is called a square streak if:

// The length of the subsequence is at least 2, and
// after sorting the subsequence, each element (except the first element) is the square of the previous number.
// Return the length of the longest square streak in nums, or return -1 if there is no square streak.

// A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

import java.util.*;

public class longestSquareStreak {
    public static int maxStreak(int[] nums) {
        int maxCount = -1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            int curr = list.get(i);
            int count = 0;

            while (set.contains(curr)) {
                set.remove(curr);
                curr = curr * curr;
                count++;
            }

            maxCount = Math.maxCount(maxCount, count);
        }

        return maxCount > 1 ? maxCount : -1;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 3, 6, 16, 8, 2 };
        System.out.println(maxStreak(nums)); // 3

        int[] nums2 = { 2, 3, 5, 6, 7 };
        System.out.println(maxStreak(nums2)); // -1

    }
}
