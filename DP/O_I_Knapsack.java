package DP;

public class O_I_Knapsack {
    
    // Recursion.....
    public static int Knapsack(int val[], int wt[], int W, int n) {
        if(W == 0 || n == 0) {
            return 0;
        }

        if( wt[n-1] <= W ) {
            // Include
            int ans1 = val[n-1] + Knapsack(val, wt, W-wt[n-1], n-1);
            // Exclude
            int ans2 = Knapsack(val, wt, W, n-1);
            return Math.max(ans1, ans2);   
        }
        else {
            return Knapsack(val, wt, W, n-1);
        }
    }


    // Memoization.....
    public static int KnapsackMemo(int val[], int wt[], int W, int n, int dp[][]) {
        if(W == 0 || n == 0) {
            return 0;
        }
        if(dp[n][W] != -1) {
            return dp[n][W];
        }

        if( wt[n-1] <= W ) {
            // Include
            int ans1 = val[n-1] + KnapsackMemo(val, wt, W-wt[n-1], n-1, dp);
            // Exclude
            int ans2 = KnapsackMemo(val, wt, W, n-1, dp);
            dp[n][W] =  Math.max(ans1, ans2);
            return dp[n][W];   
        }
        else {
            dp[n][W] =  KnapsackMemo(val, wt, W, n-1, dp);
            return dp[n][W];
        }
    }


    // Tabulation.....
    public static int KnapsackTab(int val[], int wt[], int W) {
        int n = val.length;    
        int dp[][] = new int[n+1][W+1];
            for(int i = 0; i<dp.length; i++) { // 0th column
                dp[i][0] = 0;
            }
                for(int j = 0; j < dp[0].length; j++) { // 0th row
                    dp[0][j] = 0;
                }

                for(int i=1; i<n+1; i++) {
                    for(int j=1; j<W+1; j++) {
                        int v = val[i-1]; // ith item val
                        int w = wt[i-1];   // ith item weight
                        if(w <= j) { // Valid
                           int IncludeProfit = v + dp[i-1][j-w];
                           int ExcludeProfit = dp[i-1][j];
                           dp[i][j] = Math.max(IncludeProfit, ExcludeProfit);
                        }
                        else { // Invalid
                            int ExcludeProfit = dp[i-1][j];
                            dp[i][j] = ExcludeProfit;

                        }
                    }
                }
                return dp[n][W];
    }


    public static void print (int dp[][]) {
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int val[] = {15, 14, 10, 45, 30};
        int wt[] = {2, 5, 1, 3, 4};
        int W = 7;

        int dp[][] = new int [val.length+1][W+1];
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                dp[i][j] = dp[i][j];
            }     
                }

        //System.out.println(Knapsack(val, wt, W, val.length));
        //System.out.println(KnapsackMemo(val, wt, W, val.length, dp));
        System.out.println(KnapsackTab(val, wt, W));
        print(dp);
        
    }
    
}
