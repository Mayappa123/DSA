// 2275. Largest Combination With Bitwise AND Greater Than Zero

// The bitwise AND of an array nums is the bitwise AND of all integers in nums.
// For example, for nums = [1, 5, 3], the bitwise AND is equal to 1 & 5 & 3 = 1.
// Also, for nums = [7], the bitwise AND is 7.
// You are given an array of positive integers candidates. Evaluate the bitwise AND of every combination of numbers of candidates. 
//Each number in candidates may only be used once in each combination.

// Return the size of the largest combination of candidates with a bitwise AND greater than 0.

public class Largest_Combination_with_Bitwise_AND_Greater_than_Zero {

    public static int largestCombination(int[] candidates) {
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            int count = 0;
            int bitMask = 1 << i;

            for (int j = 0; j < candidates.length; j++) {
                if ((candidates[j] & bitMask) != 0) {
                    count++;
                }
            }
            ans = Math.max(ans, count);
        }
        return ans;
    }

    public static void main(String[] args) {

        int[] candidates = { 16, 17, 71, 62, 12, 24, 14 }; // 4
        System.out.println(largestCombination(candidates));

        System.out.println(largestCombination(new int[] { 8, 8 })); // 2
    }
}