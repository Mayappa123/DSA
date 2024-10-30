// You may recall that an array arr is a mountain array if and only if:

// arr.length >= 3
// There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
// arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
// arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
// Given an integer array nums​​​, return the minimum number of elements to remove to make nums​​​ a mountain array.

import java.util.*;

public class Minimum_Number_of_Removals_to_Make_Mountain_Array {
    public static int minimumMountainRemovals(int[] nums) {
        int[] increase = new int[nums.length];
        int[] decrease = new int[nums.length];

        Arrays.fill(increase, 1);
        Arrays.fill(decrease, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    increase[i] = Math.max(increase[i], increase[j] + 1);
            }
        }

        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = nums.length - 1; j > i; j--) {
                if (nums[j] < nums[i])
                    decrease[i] = Math.max(decrease[i], decrease[j] + 1);
            }
        }

        int answer = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (increase[i] != 1 && decrease[i] != 1)
                answer = Math.max(answer, increase[i] + decrease[i] - 1);
        }
        return nums.length - answer;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 1 };
        int[] nums1 = { 2, 1, 1, 5, 6, 2, 3, 1 };

        System.out.println(minimumMountainRemovals(nums)); // 0
        System.out.println(minimumMountainRemovals(nums1)); // 3

    }
}
