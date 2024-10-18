package DP;

import java.util.Arrays;

public class Catalans_Number {

    // Recursion.....
    public static int Catalans(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int ans = 0; // Cn
        for (int i = 0; i <= n - 1; i++) {
            ans += Catalans(i) * Catalans(n - i - 1);
        }
        return ans;

    }

    // Memoization.....
    public static int Catalans_Memo(int n, int dp[]) {
        if (n == 0 || n == 0) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }
        int ans = 0; // Cn
        for (int i = 0; i < n; i++) {
            ans += Catalans_Memo(i, dp) * Catalans_Memo(n - i - 1, dp);
        }

        return dp[n] = ans;

    }

    // Tabulation.....
    public static int Catalans_Tab(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(Catalans(n));

        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(Catalans_Memo(n, dp));

        System.out.println(Catalans_Tab(n));

    }

}
