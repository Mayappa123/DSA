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