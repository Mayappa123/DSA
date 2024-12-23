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
    }
}