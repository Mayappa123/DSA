import java.util.ArrayList;
import java.util.LinkedList;

public class Maximum_Number_of_K_Divisible_Components {

    public int maxKDivisibleComponents(int n, int[][] edges, int[] vals, int k) {
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
    }
}
