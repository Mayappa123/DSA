package DP;

import java.util.Arrays;
import javax.annotation.processing.SupportedOptions;

public class Climbing_Staires {

    // Count ways to reach the nth stair. the person can climb either 1 or 2 steps
    // at a time.
    // Recursion.....
    public static int countWyas(int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        return countWyas(n - 1) + countWyas(n - 2);
    }

    // Memoization.....
    public static int findWays(int n, int ways[]) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            return 0;
        }
        if (ways[n] != -1) {
            return ways[n];
        }
        ways[n] = findWays(n - 1, ways) + findWays(n - 2, ways);
        return ways[n];
    }

    // Tabulation....
    public static int findwaysTab(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1] + 0;
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(countWyas(n));

        int ways[] = new int[n + 1];
        Arrays.fill(ways, -1);
        System.out.println(findWays(n, ways));

        System.out.println(findwaysTab(n));

    }
}
