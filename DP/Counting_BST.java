package DP;

public class Counting_BST {

    public static int countBST(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<n+1; i++) {
            for(int j=0; j<i; j++) {
                int left = dp[j];        //dp[i]
                int right = dp[i-j-1];  //dp[i-j-1]
                dp[i] += left * right;  //Ci = Cj * Ci-j-1
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(countBST(n));
    }
    
}

