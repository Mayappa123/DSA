//2471. Minimum Number of Operations to Sort a Binary Tree by Level

// You are given the root of a binary tree with unique values.
// In one operation, you can choose any two nodes at the same level and swap their values.
// Return the minimum number of operations needed to make the values at each level sorted in a strictly increasing order.
// The level of a node is the number of edges along the path between it and the root node.

import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class MinOperationsToSortTree {

    public int minimumOperations(Node root) {
        if (root == null)
            return 0;

        // Perform level-order traversal
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int operations = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            // Collect all nodes at the current level
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                level.add(node.data);
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }

            // Count the number of swaps needed to sort the current level
            operations += countSwapsToSort(level);
        }
        return operations;
    }

    private int countSwapsToSort(List<Integer> nums) {
        int n = nums.size();
        int[] sorted = nums.stream().sorted().mapToInt(Integer::intValue).toArray();

        // Map each value to its index
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(nums.get(i), i);
        }

        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            // If already visited or already in the correct position, skip
            if (visited[i] || nums.get(i) == sorted[i])
                continue;

            int cycleSize = 0;
            int j = i;

            // Count cycle size
            while (!visited[j]) {
                visited[j] = true;
                j = indexMap.get(sorted[j]);
                cycleSize++;
            }

            // If there is a cycle of size k, we need k - 1 swaps
            if (cycleSize > 1)
                swaps += (cycleSize - 1);
        }
        return swaps;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.left.left = new Node(7);
        root.left.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(4);

        MinOperationsToSortTree solution = new MinOperationsToSortTree();
        System.out.println("Minimum operations: " + solution.minimumOperations(root));

        // Input: root = [1,4,3,7,6,8,5,null,null,null,null,9,null,10]
        // Output: 3
        // Explanation:
        // - Swap 4 and 3. The 2nd level becomes [3,4].
        // - Swap 7 and 5. The 3rd level becomes [5,6,8,7].
        // - Swap 8 and 7. The 3rd level becomes [5,6,7,8].
        // We used 3 operations so return 3.
        // It can be proven that 3 is the minimum number of operations needed.
 
    }
}