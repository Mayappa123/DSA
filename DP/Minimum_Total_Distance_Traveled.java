// There are some robots and factories on the X-axis. You are given an integer array robot where robot[i] is the position of the ith robot. You are also given a 2D integer array factory where factory[j] = [positionj, limitj] indicates that positionj is the position of the jth factory and that the jth factory can repair at most limitj robots.

// The positions of each robot are unique. The positions of each factory are also unique. Note that a robot can be in the same position as a factory initially.

// All the robots are initially broken; they keep moving in one direction. The direction could be the negative or the positive direction of the X-axis. When a robot reaches a factory that did not reach its limit, the factory repairs the robot, and it stops moving.

// At any moment, you can set the initial direction of moving for some robot. Your target is to minimize the total distance traveled by all the robots.

// Return the minimum total distance traveled by all the robots. The test cases are generated such that all the robots can be repaired.

// Note that

// All robots move at the same speed.
// If two robots move in the same direction, they will never collide.
// If two robots move in opposite directions and they meet at some point, they do not collide. They cross each other.
// If a robot passes by a factory that reached its limits, it crosses it as if it does not exist.
// If the robot moved from a position x to a position y, the distance it moved is |y - x|.

import java.util.*;

public class Minimum_Total_Distance_Traveled {
    public static long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        // Sort the robot list and the factories by their positions
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        int n = robot.size();
        int m = factory.length;

        // DP table where dp[i][j] represents the minimum total distance to repair first
        // i robots using first j factories
        long[][] dp = new long[n + 1][m + 1];

        // Initialize the dp table with a large number
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }

        // Base case: 0 robots to be repaired has 0 distance
        dp[0][0] = 0;

        // Iterate over factories
        for (int j = 1; j <= m; j++) {
            // Retrieve the position and repair limit of the current factory
            int factoryPos = factory[j - 1][0];
            int factoryLimit = factory[j - 1][1];

            // Iterate over robots
            for (int i = 0; i <= n; i++) {
                // Carry forward the previous value
                dp[i][j] = dp[i][j - 1];

                // Calculate the minimum distance for each count of robots repaired by this
                // factory
                long totalDistance = 0;
                for (int k = 1; k <= factoryLimit && i - k >= 0; k++) {
                    totalDistance += Math.abs(robot.get(i - k) - factoryPos);
                    if (dp[i - k][j - 1] != Long.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - k][j - 1] + totalDistance);
                    }
                }
            }
        }

        // The answer is the minimum distance to repair all robots with all factories
        return dp[n][m];
    }

    public static void main(String[] args) {
        List<Integer> robot = Arrays.asList(0, 4, 6);
        int[][] factory = { { 2, 2 }, { 6, 2 } };
        System.out.println(minimumTotalDistance(robot, factory));
    }
}
