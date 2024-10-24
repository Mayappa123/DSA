// Given the root of a binary tree, replace the value of each node in the tree with the sum of all its cousins' values.
// Two nodes of a binary tree are cousins if they have the same depth with different parents.
// Return the root of the modified tree.
// Note that the depth of a node is the number of edges in the path from the root node to it.

import java.util.*;
public class Cousins_in_BT {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return String.valueOf(this.data);
        }
    }

    public static Node replaceValueInTree(Node root) {
        // Calculate the sum of each level
        List<Long> levelsum = levelSum(root);
        updateVal(root, 0, levelsum);
        root.data = 0; // Set root value to 0 as per the problem statement
        return root;
    }

    private static void updateVal(Node root, int level, List<Long> levelSum) {
        if (root == null || level + 1 >= levelSum.size()) {
            return;
        }

        long nextlevelSum = levelSum.get(level + 1);

        // Calculate the cousin sum by excluding the children of the current node
        if (root.left != null) {
            nextlevelSum -= root.left.data;
        }
        if (root.right != null) {
            nextlevelSum -= root.right.data;
        }

        // Update the children values, explicitly casting long to int
        if (root.left != null) {
            root.left.data = (int) nextlevelSum;
        }
        if (root.right != null) {
            root.right.data = (int) nextlevelSum;
        }

        // Recur for the next level
        updateVal(root.left, level + 1, levelSum);
        updateVal(root.right, level + 1, levelSum);
    }

    private static List<Long> levelSum(Node root) {
        List<Long> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                sum += curr.data;

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            ans.add(sum);
        }
        return ans;
    }

    public static void printTreeLevelOrder(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");

            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }
    }

    public static void main(String[] args) {

        Node root = new Node(5);           // Node root = new Node(1);
        root.left = new Node(4);           // root.left = new Node(2);
        root.right = new Node(9);          // root.right = new Node(3);
        root.left.left = new Node(1);      // root.left.left = new Node(4);
        root.left.right = new Node(10);    // root.left.right = new Node(5);
        root.right.left = new Node(0);     // root.right.left = new Node(6);
        root.right.right = new Node(7);    // root.right.right = new Node(7);
        // output : 0 0 0 7 7 11 11             // output : 0 0 0 13 13 9 9

        replaceValueInTree(root);
        printTreeLevelOrder(root); // Print the tree in level-order to show the result
    }
}
