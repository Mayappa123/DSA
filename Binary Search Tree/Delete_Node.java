public class Delete_Node {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // Function to insert nodes in the binary search tree
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val < root.data) {
            root.left = insert(root.left, val);
        } else if (val > root.data) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static Node delete(Node root, int val) {
        if (root == null) {
            return null; // Tree is empty
        }

        if (root.data > val) {
            root.left = delete(root.left, val);
        } else if (root.data < val) {
            root.right = delete(root.right, val);
        } else { // root.data == val

            // case 1: No child
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2: One child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case 3: Two children
            Node IS = InorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node InorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // in-order traversal
    public static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;

        // Inserting values into the BST
        for (int val : values) {
            root = insert(root, val);
        }

        System.out.println("In-order traversal before deletion:");
        inorder(root);
        System.out.println();

        // Delete node
        root = delete(root, 4);

        System.out.println("In-order traversal after deletion:");
        inorder(root);
    }
}
