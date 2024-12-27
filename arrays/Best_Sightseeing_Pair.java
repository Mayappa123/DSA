//1014. Best Sightseeing Pair

// The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j: the sum of the values of the sightseeing spots, minus the distance between them.
// Return the maximum score of a pair of sightseeing spots.

public class Best_Sightseeing_Pair {
    public static int maxScoreSightseeingPair(int[] values) {
        int ans = Integer.MIN_VALUE;
        int m = values[0];

        for (int i = 1; i < values.length; i++) {
            if (values[i] - i + m > ans)
                ans = values[i] - i + m;

            if (values[i] + i > m)
                m = values[i] + i;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] valuse = { 8, 1, 5, 2, 6 };
        System.out.println(maxScoreSightseeingPair(valuse));

        // Example 1:
        // Input: values = [8,1,5,2,6]
        // Output: 11
        // Explanation: i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11

    }
}
