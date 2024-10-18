class Trees_Identical {
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

    public class BinaryTree {
        Node root1, root2;

        boolean IdenticalTrees(Node root1, Node root2) {
            if (root1 == null && root2 == null) {
                return true;
            }
            if (root1 != null && root2 != null) {
                return (root1.data == root2.data
                        && IdenticalTrees(root1.left, root2.left)
                        && IdenticalTrees(root1.right, root2.right));
            } else
                return false;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root1 = new Node(1);
        tree.root1.left = new Node(2);
        tree.root1.right = new Node(3);
        tree.root1.left.left = new Node(4);
        tree.root1.left.right = new Node(5);

        tree.root2 = new Node(1);
        tree.root2.left = new Node(2);
        tree.root2.right = new Node(3);
        tree.root2.left.left = new Node(4);
        tree.root2.left.right = new Node(5);

        if (tree.IdenticalTrees(tree.root1, tree.root2)) {
            System.out.println(" Both trees are identical.");
        } else {
            System.out.println(" Both are not identical.");
        }

    }

}
