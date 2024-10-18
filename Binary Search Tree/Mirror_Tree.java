public class Mirror_Tree {
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

    public static Node CreateMirror(Node root) {
        if (root == null) {
            return null;
        }

        Node leftMirror = CreateMirror(root.left);
        Node RightMirror = CreateMirror(root.right);
        return root;
    }

    public static void PreOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        PreOrder(root.left);
        PreOrder(root.right);

    }

    public static void main(String[] args) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.left = new Node(11);
        root.right.right = new Node(12);

        root = CreateMirror(root);
        PreOrder(root);

    }
}
