//1574. Shortest Subarray to be Removed to Make Array Sorted

//Given an integer array arr, remove a subarray (can be empty) from arr such that the remaining elements in arr are non-decreasing.
// Return the length of the shortest subarray to remove.
// A subarray is a contiguous subsequence of the array.

public class Shortest_Subarray_to_be_Removed_to_Make_Array_Sorted {

    public static int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        // Find the longest non-decreasing prefix
        int left = 0;
        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }

        // If the entire array is non-decreasing, return 0
        if (left == n - 1)
            return 0;

        // Find the longest non-decreasing suffix
        int right = n - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }

        // Initial answer could be either removing the prefix or the suffix completely
        int minRemove = Math.min(n - left - 1, right);

        // Try to merge prefix and suffix by sliding
        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                minRemove = Math.min(minRemove, j - i - 1);
                i++;
            } else {
                j++;
            }
        }

        return minRemove;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 10, 4, 2, 3, 5 };
        System.out.println(findLengthOfShortestSubarray(nums)); // 3

    }
}
