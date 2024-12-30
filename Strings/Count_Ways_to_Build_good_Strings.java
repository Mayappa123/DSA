//2466. Count Ways To Build Good Strings

// Given the integers zero, one, low, and high, we can construct a string by starting with an empty string, and then at each step perform either of the following:
// Append the character '0' zero times.
// Append the character '1' one times.
// This can be performed any number of times.
// A good string is a string constructed by the above process having a length between low and high (inclusive).
// Return the number of different good strings that can be constructed satisfying these properties. Since the answer can be large, return it modulo 109 + 7.

public class Count_Ways_to_Build_good_Strings {
    private int mod = (int) 1e9 + 7;

    public static int countGoodStrings(int low, int high, int zero, int one) {
        if (zero > one)
            return countGoodStrings(low, high, one, zero);

        int dp[] = new int[high + 1], res = 0;
        dp[0] = 1;

        for (int i = 1; i <= high; i++) {
            if (i >= zero)
                dp[i] = (dp[i] + dp[i - zero]) % mod;
            if (i >= one)
                dp[i] = (dp[i] + dp[i - one]) % mod;
            if (i >= low)
                res = (res + dp[i]) % mod;
        }

        return res;
    }

    public static void main(String[] args) {
        int low = 3, high = 3, zero = 1, one = 1;

        System.out.println(countGoodStrings(low, high, zero, one));

        // Example 1:
        // Input: low = 3, high = 3, zero = 1, one = 1
        // Output: 8
        // Explanation:
        // One possible valid good string is "011".
        // It can be constructed as follows: "" -> "0" -> "01" -> "011".
        // All binary strings from "000" to "111" are good strings in this example.
    }
}
