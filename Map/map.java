// 2940. Find Building Where Alice and Bob Can Meet

// You are given a 0-indexed array heights of positive integers, where heights[i] represents the height of the ith building.
// If a person is in building i, they can move to any other building j if and only if i < j and heights[i] < heights[j].
// You are also given another array queries where queries[i] = [ai, bi]. 
//On the ith query, Alice is in building ai while Bob is in building bi.
// Return an array ans where ans[i] is the index of the leftmost building where Alice and Bob can meet on the ith query. 
//If Alice and Bob cannot move to a common building on query i, set ans[i] to -1.


import java.util.*;

public class map {

    public static int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int[] ans = new int[queries.length];
        Arrays.fill(ans, -1);
        List<int[]>[] tempQueries = new List[heights.length];
        for (int i = 0; i < heights.length; i++) {
            tempQueries[i] = new ArrayList<>();
        }
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0];
            int b = queries[i][1];
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            if ((a < b && heights[a] < heights[b]) || a == b) {
                ans[i] = b;
            } else {
                tempQueries[b].add(new int[] { heights[a], i });
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < heights.length; i++) {
            while (!pq.isEmpty() && pq.peek()[0] < heights[i]) {
                ans[pq.remove()[1]] = i;
            }
            for (int[] tempQuery : tempQueries[i]) {
                pq.add(tempQuery);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        iint[] height = { 6, 4, 8, 5, 2, 7 };
        int[][] queries = { { 0, 1 }, { 0, 3 }, { 2, 4 }, { 3, 4 }, { 2, 2 } };
        System.out.println(Arrays.toString(leftmostBuildingQueries(height, queries)));
    }
}