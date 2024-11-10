//3097. Shortest_Subarray_With_OR_at_Least_K_II

// You are given an array nums of non-negative integers and an integer k.
// An array is called special if the bitwise OR of all of its elements is at least k.
// Return the length of the shortest special non-empty subarray.
//  of nums, or return -1 if no special subarray exists.

public class Shortest_Subarray_With_OR_at_Least_K_II {

    public static int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int[] bitCount = new int[32];
        int currentOR = 0;
        int left = 0;
        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            currentOR |= nums[right];

            for (int bit = 0; bit < 32; bit++) {
                if ((nums[right] & (1 << bit)) != 0) {
                    bitCount[bit]++;
                }
            }

            while (left <= right && currentOR >= k) {
                minLength = Math.min(minLength, right - left + 1);

                int updatedOR = 0;
                for (int bit = 0; bit < 32; bit++) {
                    if ((nums[left] & (1 << bit)) != 0) {
                        bitCount[bit]--;
                    }
                    if (bitCount[bit] > 0) {
                        updatedOR |= (1 << bit);
                    }
                }
                currentOR = updatedOR;
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        int k = 2;
        System.out.println(minimumSubarrayLength(nums, k)); // 1

        int[] nums2 = { 2, 1, 8 };
        int k2 = 10;
        System.out.println(minimumSubarrayLength(nums2, k2));// 3


    }
}
