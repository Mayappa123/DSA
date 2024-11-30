//2097. Valid Arrangement of Pairs

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class Valid_Arrangement_of_Pairs {

    public static int[][] validArrangement(int[][] pairs) {
        // Step 1: Build the graph
        Map<Integer, Stack<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Map<Integer, Integer> outDegree = new HashMap<>();

        for (int[] pair : pairs) {
            int start = pair[0], end = pair[1];
            graph.putIfAbsent(start, new Stack<>());
            graph.get(start).push(end);
            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
        }

        // Step 2: Find the starting node
        int startNode = pairs[0][0];
        for (int node : graph.keySet()) {
            if (outDegree.getOrDefault(node, 0) > inDegree.getOrDefault(node, 0)) {
                startNode = node;
                break;
            }
        }

        // Step 3: Perform Hierholzer’s Algorithm to find the Eulerian path
        LinkedList<Integer> path = new LinkedList<>();
        dfs(graph, startNode, path);

        // Step 4: Convert the path into the result format
        int[][] result = new int[pairs.length][2];
        int index = 0;
        Iterator<Integer> it = path.iterator();
        int prev = it.next();
        while (it.hasNext()) {
            int curr = it.next();
            result[index++] = new int[] { prev, curr };
            prev = curr;
        }
        return result;
    }

    private static void dfs(Map<Integer, Stack<Integer>> graph, int node, LinkedList<Integer> path) {
        Stack<Integer> stack = graph.get(node);
        while (stack != null && !stack.isEmpty()) {
            dfs(graph, stack.pop(), path);
        }
        path.addFirst(node);
    }

    public static void main(String[] args) {
        int[][] pairs = { { 2, 4 }, { 3, 7 }, { 4, 3 }, { 7, 2 } };
        System.out.println(validArrangement(pairs));

    }
}
