package DP;

import java.util.Arrays;

public class Matrix_Chain_Multiplication {
       
    public static int mcm(int arr[], int i, int j) {
        if(i == j) {
            return 0;  // Single Matrix Case
        }

        int ans = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++) {
            int Cost1 = mcm(arr, i, k);  //Ai...Ak -->arr[i-1] * arr[1]
            int Cost2 = mcm(arr, k+1, j);  //Ai+1...Aj -->arr[k] * arr[j]
            int Cost3 = arr[i-1] * arr[k] * arr[j];
            int FinalCost = Cost1 + Cost2 + Cost3;
            ans = Math.min(ans, FinalCost);
        }

        return ans;  //min cost
    }


    //Memoization......
    public static int mcmMem (int arr[], int i, int j, int dp[][]) {
        if(i == j) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;
        for(int k=i; k<=j-1; k++) {
            int Cost1 = mcmMem(arr, i, k, dp);
            int Cost2 = mcmMem(arr, k+1, j, dp);
            int Cost3 = arr[i-1] * arr[k] * arr[j];
            ans = Math.min(ans,  Cost1 + Cost2 + Cost3);
        }

        return dp[i][j] = ans;
        
    }


    public static int mcmTab(int arr[]) {
        int n = arr.length;
        int dp[][] = new int[n][n];

        //Initialization.....
        for(int i=0; i<n; i++) {
            dp[i][i] = 0;
            }

        //Bottom Up.....
        for(int len=2; len<=n-1; len++) {
            for(int i=1; i<=n-len; i++) {
                int j = i+len-1;  //Column
                dp[i][j] = Integer.MAX_VALUE;
                for(int k=i; k<=j-1; k++) {
                    int Cost1 = dp[i][k];
                    int Cost2 = dp[k+1][j];
                    final int Cost3 = arr[i-1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j], Cost1 + Cost2 + Cost3);
                    }
            }

        }
        print(dp);
        return dp[1][n-1];
    }

    public static void print(int dp[][]) {
        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
                }
                System.out.println();
                }
                System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 3};
        int n = arr.length;
        //System.out.println(mcm(arr, 1, n-1));

        int dp[][] = new int [n][n];
        for(int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
            System.out.println(mcmMem(arr, 1, n-1, dp));

            System.out.println(mcmTab(arr));
            System.out.println();
            print(dp);
        }
    }
}
