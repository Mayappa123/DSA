//2762. Continuous Subarrays

// You are given a 0-indexed integer array nums. A subarray of nums is called continuous if:

// Let i, i + 1, ..., j be the indices in the subarray. 
//Then, for each pair of indices i <= i1, i2 <= j, 0 <= |nums[i1] - nums[i2]| <= 2.
// Return the total number of continuous subarrays.

// A subarray is a contiguous non-empty sequence of elements within an array.

import java.util.HashMap;
import java.util.Map;

public class Contineous_Subarrays {

    public static long continuousSubarrays(int[] nums) {
        int n = nums.length;
        int j = 0;
        long count = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            while ((i - j + 1) > getCount(nums[i], map)) {
                map.put(nums[j], map.get(nums[j]) - 1);

                j++;
            }

            count += (i - j + 1);
        }

        return count;
    }

    private static int getCount(int num, Map<Integer, Integer> map) {
        return map.getOrDefault(num, 0) + map.getOrDefault(num - 1, 0) +
                map.getOrDefault(num + 1, 0) + map.getOrDefault(num - 2, 0) +
                map.getOrDefault(num + 2, 0);
    }

    public static void main(String[] args) {

        int[] nums = { 5, 4, 2, 4 };
        System.out.println(continuousSubarrays(nums)); // 8

        // Explanation:
        // Continuous subarray of size 1: [5], [4], [2], [4].
        // Continuous subarray of size 2: [5,4], [4,2], [2,4].
        // Continuous subarray of size 3: [4,2,4].
        // Thereare no subarrys of size 4.
        // Total continuous subarrays = 4 + 3 + 1 = 8.
        // It can be shown that there are no more continuous subarrays.
    }
}
