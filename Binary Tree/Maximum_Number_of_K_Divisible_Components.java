//2872. Maximum Number of K-Divisible Components

// There is an undirected tree with n nodes labeled from 0 to n - 1. 
//You are given the integer n and a 2D integer array edges of length n - 1, where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.
// You are also given a 0-indexed integer array values of length n, where values[i] is the value associated with the ith node, and an integer k.
// A valid split of the tree is obtained by removing any set of edges, possibly empty, from the tree such that the resulting components all have values that are divisible by k, where the value of a connected component is the sum of the values of its nodes.

import java.util.*;

public class Maximum_Number_of_K_Divisible_Components {

    public static int maxKDivisibleComponents(int n, int[][] edges, int[] vals, int k) {
        if (n < 2)
            return 1;

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        int[] degree = new int[n];

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        long[] nodeVals = new long[n];
        for (int i = 0; i < n; i++)
            nodeVals[i] = vals[i];
        Queue<Integer> leafQ = new LinkedList<>();
        for (int i = 0; i < n; i++)
            if (degree[i] == 1)
                leafQ.add(i);

        int compCnt = 0;
        while (!leafQ.isEmpty()) {
            int curr = leafQ.poll();
            degree[curr]--;
            long carry = 0;

            if (nodeVals[curr] % k == 0)
                compCnt++;
            else
                carry = nodeVals[curr];

            for (int nbr : graph.get(curr)) {
                if (degree[nbr] == 0)
                    continue;
                degree[nbr]--;
                nodeVals[nbr] += carry;
                if (degree[nbr] == 1)
                    leafQ.add(nbr);
            }
        }

        return compCnt;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = { { 0, 2 }, { 1, 2 }, { 1, 3 }, { 2, 4 } };
        int[] values = { 1, 8, 1, 4, 4 };
        int k = 6;

        System.out.println(maxKDivisibleComponents(n, edges, values, k));

        // Input: n = 5, edges = [[0,2],[1,2],[1,3],[2,4]], values = [1,8,1,4,4], k = 6
        // Output: 2
        // Explanation: 
        // We remove the edge connecting node 1 with 2. The resulting split is valid because:
        // - The value of the component containing nodes 1 and 3 is values[1] + values[3] = 12.
        // - The value of the component containing nodes 0, 2, and 4 is values[0] + values[2] + values[4] = 6.
        // It can be shown that no other valid split has more than 2 connected components.

    }
}
