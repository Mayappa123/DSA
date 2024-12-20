import java.util.*;

public class Reverse_Odd_Levels_in_BT {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node reverseOddLevels(Node root) {
        if (root == null || root.left == null || root.right == null) {
            return root;
        }
        levelTraverse(root.left, root.right, 0);
        return root;
    }

    private static void levelTraverse(Node left, Node right, int level) {
        if (left == null || right == null)
            return;

        // Swap data for nodes at odd levels
        if (level % 2 == 0) {
            int data = left.data;
            left.data = right.data;
            right.data = data;
        }

        // Recursively traverse the next level
        levelTraverse(left.left, right.right, level + 1);
        levelTraverse(left.right, right.left, level + 1);
    }

    // Helper method to perform a level-order traversal and print the tree
    private static void printTree(Node root) {
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
        System.out.println();
    }

    public static void main(String[] args) {
        // Constructing the binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Original Tree:");
        printTree(root);

        // Reverse odd levels
        reverseOddLevels(root);

        System.out.println("Tree After Reversing Odd Levels:");
        printTree(root);
    }
}
