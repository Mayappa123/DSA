// 2415. Reverse Odd Levels of Binary Tree

// Given the root of a perfect binary tree, reverse the node values at each odd level of the tree.
// For example, suppose the node values at level 3 are [2,1,3,4,7,11,29,18], then it should become [18,29,11,7,4,3,1,2].
// Return the root of the reversed tree.
// A binary tree is perfect if all parent nodes have two children and all leaves are on the same level.
// The level of a node is the number of edges along the path between it and the root node.

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
// Original Tree : 1 2 3 4 5 6 7
// Tree After Reversing Odd Levels : 1 3 2 4 5 6 7

// Input: root = [7,13,11]
// Output: [7,11,13]
// Explanation:
// The nodes at level 1 are 13, 11, which are reversed and become 11, 13.