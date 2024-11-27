//3243. Shortest Distance After Road Addition Queries I

import java.util.*;

public class Shortest_Distance_After_Road_Addition_Queries {

    private static void updateDistances(List<List<Integer>> graph, int current, int[] distances) {
        int newDist = distances[current] + 1;

        for (int neighbor : graph.get(current)) {
            if (distances[neighbor] <= newDist)
                continue;

            distances[neighbor] = newDist;
            updateDistances(graph, neighbor, distances);
        }
    }

    public static int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] distances = new int[n];
        for (int i = 0; i < n; i++) {
            distances[i] = n - 1 - i;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i + 1 < n; ++i) {
            graph.get(i + 1).add(i);
        }

        int[] answer = new int[queries.length];
        int queryIdx = 0;

        for (int[] query : queries) {
            int source = query[0];
            int target = query[1];

            graph.get(target).add(source);
            distances[source] = Math.min(distances[source], distances[target] + 1);
            updateDistances(graph, source, distances);

            answer[queryIdx++] = distances[0];
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] queries = { { 2, 4 }, { 0, 2 }, { 0, 4 } };

        int[] ans = shortestDistanceAfterQueries(n, queries);
        System.out.println(Arrays.toString(ans)); // [3, 2, 1]
    }
}

// You are given an integer n and a 2D integer array queries.

// There are n cities numbered from 0 to n - 1.
// Initially, there is a unidirectional road from city i to city i + 1 for all 0
// <= i < n - 1.

// queries[i] = [ui, vi] represents the addition of a new unidirectional road
// from city ui to city vi.
// After each query, you need to find the length of the shortest path from city
// 0 to city n - 1.

// Return an array answer where for each i in the range [0, queries.length - 1],
// answer[i] is the length of the shortest path from city 0 to city n - 1 after
// processing the first i + 1 queries.
