
import java.util.*;

import javax.swing.tree.TreeNode;

public class Height_of_BT_after_subTree_removal {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Approach1
    public static int Height(Node root) {
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(Height(root.left), Height(root.right));
    }

    public static Node removeSubTree(Node root, int target) {
        if (root == null) {
            return null;
        }
        if (root.data == target) {
            return null;
        }
        root.left = removeSubTree(root.left, target);
        root.right = removeSubTree(root.right, target);
        return root;
    }

    public static Node deepCopy(Node root) {
        if (root == null) {
            return null;
        }
        Node newNode = new Node(root.data);
        newNode.left = deepCopy(root.left);
        newNode.right = deepCopy(root.right);
        return newNode;
    }

    public static int[] TreeQueries(Node root, int[] queries) {
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            Node copy = deepCopy(root);
            copy = removeSubTree(copy, queries[i]);
            ans[i] = Height(copy);
        }
        return ans;
    }

    // Approach2
    public static int max;

    public int[] treeQueries2(TreeNode root, int[] queries) {
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        max = 0;

        leftFirst(root, left, 0);

        max = 0;
        rightFirst(root, right, 0);

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            result[i] = Math.max(left.getOrDefault(query, 0), right.getOrDefault(query, 0));
        }
        return result;
    }

    private static void leftFirst(TreeNode root, Map<Integer, Integer> left, int depth) {
        if (root == null) {
            return;
        }
        left.put(root.val, max);
        max = Math.max(max, depth);
        leftFirst(root.left, left, depth + 1);
        leftFirst(root.right, left, depth + 1);
    }

    private static void rightFirst(TreeNode root, Map<Integer, Integer> right, int depth) {
        if (root == null) {
            return;
        }
        right.put(root.val, max);
        max = Math.max(max, depth);
        rightFirst(root.right, right, depth + 1);
        rightFirst(root.left, right, depth + 1);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int[] queries = { 2, 3 };

        int[] result = TreeQueries(root, queries);

        System.out.println("Height of the tree after each query:");
        for (int height : result) {
            System.out.println(height);
        }
    }
}
