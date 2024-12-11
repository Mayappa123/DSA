
// You are given a 0-indexed array nums and a non-negative integer k.
// In one operation,you can do the following:
// Choose an index i that hasn'tbeen chosen before from the range[0,nums.length-1].
//Replace nums[i]with any integer from the range[nums[i]-k,nums[i]+k].
//The beauty of the array is the length of the longest subsequence consisting of equal elements.
// Return the maximum possible beauty of the array nums after applying the operation any number of times.
// Note that you can apply the operation to each index only once.
// A subsequence of an array is a new array generated from the original array by deleting some elements(possibly none)without changing the order of the remaining elements.

import java.util.Arrays;
public class Max_Beauty_of_an_Array {
    public static int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0, j, n = nums.length;

        for (j = 0; j < n; ++j) {
            if (nums[j] - nums[i] > k * 2) {
                i++;
            }
        }
        return j - i;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 6, 1, 2 };
        int k = 2;

        System.out.println(maximumBeauty(nums, k));  //3
    }
}
