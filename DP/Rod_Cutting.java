package DP;

public class Rod_Cutting {

    public static int RodCutting(int length[], int price[], int TotalRod) {
        int n = price.length;
        int dp[][] = new int[n + 1][TotalRod + 1];

        for(int i=0; i<n+1; i++) {
            for(int j=0; j<TotalRod+1; j++) {
                if(i == 0 ||j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for(int i=1; i<n+1; i++) {
            for(int j=1; j<TotalRod+1; j++) {
                // Valid
                if(length[i-1] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], price[i-1] + dp[i][j-length[i-1]]);
                      }
                    else { // Invalid
                        dp[i][j] = dp[i-1][j];
                        }
                }
        }
        return dp[n][TotalRod];
    }

    public static void main(String[] args) {
        int length[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int price[] = {1, 5, 8, 9, 10, 17, 17, 20};
        int TotalRod = 8;
        System.out.println(RodCutting(length, price, TotalRod));
    }
    
}
