public class Largest_BST_in_BT {
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

    static class info {
        boolean isBST;
        int size;
        int min;
        int max;

        public info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBST = 0;

    public static info LargestBST(Node root) {
        if (root == null) {
            return new info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        info leftinfo = LargestBST(root.left);
        info rightinfo = LargestBST(root.right);
        int size = leftinfo.size + rightinfo.size + 1;
        int min = Math.min(root.data, Math.min(leftinfo.min, rightinfo.min));
        int max = Math.max(root.data, Math.max(leftinfo.max, rightinfo.max));

        if (root.data <= leftinfo.max || root.data >= rightinfo.min) {
            return new info(false, size, min, max);
        }

        if (leftinfo.isBST && rightinfo.isBST) {
            maxBST = Math.max(maxBST, size);
            return new info(true, size, min, max);
        }
        return new info(false, size, min, max);
    }

    public static void main(String[] args) {

        Node root = new Node(50);
        root.left = new Node(30);
        root.left.left = new Node(5);
        root.left.right = new Node(20);

        root.right = new Node(60);
        root.right.left = new Node(45);
        root.right.right = new Node(70);
        root.right.right.left = new Node(65);
        root.right.right.right = new Node(80);

        info info = LargestBST(root);
        System.out.println("Largest BST size = " + maxBST);

    }
}
