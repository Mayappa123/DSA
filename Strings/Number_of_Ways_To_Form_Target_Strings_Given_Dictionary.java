//1639. Number of Ways to Form a Target String Given a Dictionary

// You are given a list of strings of the same length words and a string target.
// Your task is to form target using the given words under the following rules:
// target should be formed from left to right.
// To form the ith character (0-indexed) of target, you can choose the kth character of the jth string in words if target[i] = words[j][k].
// Once you use the kth character of the jth string of words, you can no longer use the xth character of any string in words where x <= k. 
//In other words, all characters to the left of or at index k become unusuable for every string.
// Repeat the process until you form the string target.
// Notice that you can use multiple characters from the same string in words provided the conditions above are met.
// Return the number of ways to form target from words. Since the answer may be too large, return it modulo 109 + 7.

import java.util.Arrays;

public class Number_of_Ways_To_Form_Target_Strings_Given_Dictionary {
    public static int numWays(String[] words, String target) {
        int n = words.length;
        int m = words[0].length();
        int mod = 1_000_000_007;
        int[][] A = new int[m][26];
        for (String word : words) {
            for (int j = 0; j < m; j++) {
                A[j][word.charAt(j) - 'a']++;
            }
        }
        int[][] dp = new int[m][target.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return F(0, 0, target, A, dp, mod);
    }

    public static int F(int i, int j, String target, int[][] A, int[][] dp, int mod) {
        if (j == target.length()) {
            return 1;
        }
        if (i == A.length) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        long count = F(i + 1, j, target, A, dp, mod);
        count %= mod;
        count += (1L * A[i][target.charAt(j) - 'a'] * F(i + 1, j + 1, target, A, dp, mod)) % mod;
        count %= mod;
        return dp[i][j] = (int) count;
    }

    public static void main(String[] args) {
        String words = { "acca", "bbbb", "caca" };
        String target = "aba";

        System.out.println(numWays(String[] words, target));

        // Input: words = ["acca","bbbb","caca"], target = "aba"
        // Output: 6
        // Explanation: There are 6 ways to form target.
        // "aba" -> index 0 ("acca"), index 1 ("bbbb"), index 3 ("caca")
        // "aba" -> index 0 ("acca"), index 2 ("bbbb"), index 3 ("caca")
        // "aba" -> index 0 ("acca"), index 1 ("bbbb"), index 3 ("acca")
        // "aba" -> index 0 ("acca"), index 2 ("bbbb"), index 3 ("acca")
        // "aba" -> index 1 ("caca"), index 2 ("bbbb"), index 3 ("acca")
        // "aba" -> index 1 ("caca"), index 2 ("bbbb"), index 3 ("caca")
    }
}
