package DP;

public class Unbounded_Knapsack {

    public static int Unbounded_KnapSack(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];

        for(int i=0; i<n+1; i++) {
            dp[i][0] = 0;
        }
            for(int j=0; j<W+1; j++) {
                dp[0][j] = 0;
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<W+1; j++) {
                if( wt[i-1] <= j) { // Valid
                    dp[i][j] = Math.max(dp[i-1][j], val[i-1] + dp[i][j-wt[i-1]]);
                }
                    else { // Invalid 
                        dp[i][j] = dp[i-1][j];
                    
                    }
                }

        }
        return dp[n][W];

    }

    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;
        System.out.println(Unbounded_KnapSack(val, wt, W));

        
    }

}
    

