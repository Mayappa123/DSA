public class Kth_Smallest_in_BST {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static int count = 0; // To keep track of the number of nodes visited
    static int ans = -1; // To store the k-th smallest element

    static void KthSmallest(Node root, int k) {
        if (root == null) {
            return;
        }

        // In-order traversal: Left -> Node -> Right
        KthSmallest(root.left, k);

        count++;
        if (count == k) {
            ans = root.data;
            return;
        }

        KthSmallest(root.right, k);
    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.left = new Node(9);
        root.right.right = new Node(12);

        int k = 5;
        KthSmallest(root, k);
        System.out.println(k + "-th smallest element is " + ans);
    }
}
