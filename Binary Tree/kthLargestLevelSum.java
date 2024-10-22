import java.util.*;

public class kthLargestLevelSum {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int kthLargestLevelSuminBT(Node root, int k) {
        if (root == null) {
            return -1;
        }

        Queue<Node> q = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        q.add(root);

        // Corrected the condition to use 'q' instead of 'pq'
        while (!q.isEmpty()) {
            int size = q.size();
            int sum = 0;

            for (int i = 0; i < size; i++) {
                Node node = q.remove();
                sum += node.data;

                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }

            // Add the level sum to the min-heap
            pq.add(sum);

            // If heap size exceeds k, remove the smallest element
            if (pq.size() > k) {
                pq.remove();
            }
        }

        // If there are fewer than k levels, return -1
        if (pq.size() < k) {
            return -1;
        }

        // The root of the min-heap is the kth largest level sum
        return pq.peek();
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int ans = kthLargestLevelSuminBT(root, 1);
        System.out.println("ans = " + ans);
    }
}
