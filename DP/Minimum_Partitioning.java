package DP;

public class Minimum_Partitioning {

    public static int Minimum_Partitioning(int arr[]) {
        int n = arr.length;
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
            sum += arr[i];
        }

        int w = sum/2;

        //Bottom up.....
        int dp[][] = new int[n+1][w+1];
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<w+1; j++) {
                if(arr[i-1] <= j) {    //Valid
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-arr[i-1]] + arr[i-1]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        int sum1 = dp[n][w];
        int sum2 = sum - sum1;
        return Math.abs(sum1- sum2);
    }
    public static void main(String[] args) {
        int[] arr = {1, 6, 11, 5};
        System.out.println(Minimum_Partitioning(arr));
    }
    
}
