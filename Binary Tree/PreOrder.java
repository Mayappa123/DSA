import java.util.*;

public class PreOrder {

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

    static class BinaryTree {
        static int idx = -1;

        public static Node BuildTree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = BuildTree(nodes);
            newNode.right = BuildTree(nodes);

            return newNode;
        }

        public static void PreOrder(Node root) { // Root -> Left -> right
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            PreOrder(root.left);
            PreOrder(root.right);
        }

        public static void InOrder(Node root) { // Left -> Root -> Right
            if (root == null) {
                return;
            }
            InOrder(root.left);
            System.out.print(root.data + " ");
            InOrder(root.right);
        }

        public static void PostOrder(Node root) { // Left -> Right -> Root
            if (root == null) {
                return;
            }
            PostOrder(root.left);
            PostOrder(root.right);
            System.out.print(root.data + " ");
        }

        public static void LevelOrder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node currnode = q.remove();
                if (currnode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currnode.data + " ");
                    if (currnode.left != null) {
                        q.add(currnode.left);
                    }
                    if (currnode.right != null) {
                        q.add(currnode.right);
                    }
                }
            }
        }

        public static int CountOfNodes(Node root) {
            if (root == null) {
                return 0;
            }
            int leftnodes = CountOfNodes(root.left);
            int rightnodes = CountOfNodes(root.right);
            return leftnodes + rightnodes + 1;
        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        // Create the BinaryTree object to call its methods
        BinaryTree tree = new BinaryTree();
        Node root = tree.BuildTree(nodes);

        System.out.print("PreOrder Traversal --> ");
        tree.PreOrder(root);
        System.out.println();

        System.out.print("InOrder Traversal --> ");
        tree.InOrder(root);
        System.out.println();

        System.out.print("PostOrder Traversal --> ");
        tree.PostOrder(root);
        System.out.println();

        System.out.print("Total number of nodes in tree --> ");
        System.out.println(tree.CountOfNodes(root));
        System.out.println();

        System.out.println("Level Order Traversal --> ");
        tree.LevelOrder(root);
        System.out.println();
    }
}
