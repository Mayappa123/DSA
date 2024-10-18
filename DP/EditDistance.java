package DP;

public class EditDistance {

    public static int EditDistance (String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];

        //Initialize.....
        for (int i=0; i <n+1; i++) {
            for(int j=0; i<m+1; i++) {
                if (i == 0) {
                    dp[i][j] = j;
                    }
                    else if (j == 0) {
                        dp[i][j] = i;
                    }
                }

        }

        //Bottom Up.....
        for (int i=1; i<n+1; i++) {
            for (int j=1; j<m+1; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) { //Same 
                    dp[i][j] = dp[i-1][j-1];
                    }
                    else { //diff
                        int add = dp[i][j-1] + 1;
                        int del = dp[i-1][j] + 1;
                        int rep = dp[i-1][j-1];
                        dp[i][j] = 1 + Math.min(add, Math.min(del, rep));
                    }
                }
        }
        return dp[n][m];

    }

    public static void main(String[] args) {
        String s1 = "Intention";
        String s2 = "Execution";
        System.out.println(EditDistance(s1, s2));
    }
    
}
