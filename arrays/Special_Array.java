//3152. Special Array II

// An array is considered special if every pair of its adjacent elements contains two numbers with different parity.
// You are given an array of integer nums and a 2D integer matrix queries, where for queries[i] = [fromi, toi].
//your task is to check that subarray nums[fromi..toi] is special or not.
// Return an array of booleans answer such that answer[i] is true if nums[fromi..toi] is special.

public class Special_Array {

    public static boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] prefix = new int[n]; // Prefix array to count special pairs
        boolean[] result = new boolean[queries.length]; // Result array

        // Step 1: Build the prefix array
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1];
            if ((nums[i - 1] % 2 == 0 && nums[i] % 2 == 0) ||
                    (nums[i - 1] % 2 != 0 && nums[i] % 2 != 0)) {
                prefix[i]++;
            }
        }

        // Step 2: Process each query
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            // Calculate the number of special pairs in the range
            int specialCount = prefix[right] - (left > 0 ? prefix[left - 1] : 0);

            // If no special pairs, the result is true; otherwise, false
            result[i] = (specialCount == 0);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 4, 1, 2, 6 };
        int[][] queries = { { 0, 4 } };

        boolean[] arr = isArraySpecial(nums, queries);

        for (boolean i : arr) {
            System.out.println(i); // false
            
            // The subarray is [3,4,1,2,6]. 2 and 6 are both even.

        }
    }
}
