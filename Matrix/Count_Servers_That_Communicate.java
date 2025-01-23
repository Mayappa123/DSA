
// You are given a map of a server center, represented as a m * n integer matrix grid, 
//where 1 means that on that cell there is a server and 0 means that it is no server. 
//Two servers are said to communicate if they are on the same row or on the same column.
// Return the number of servers that communicate with any other server.

public class Count_Servers_That_Communicate {

    public static int countServers(int[][] grid) {
        int[] Rows = new int[grid.length];
        int[] Col = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                Rows[i] += grid[i][j];
                Col[j] += grid[i][j];
            }
        }
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && (Rows[i] > 1 || Col[j] > 1)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 0 }, { 0, 1 } };
        System.out.println(countServers(grid));

        // Input: grid = [[1,0],[0,1]]
        // Output: 0
        // Explanation: No servers can communicate with others.
    }
}