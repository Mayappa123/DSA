 
public class Build_Tree { 
    static class Node {
        int data;
        Node left;
        Node right;

        public Node ( int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node Insert ( Node root, int value) {
        if( root == null) {
            root = new Node(value);
            return root;
        }
        if( root.data > value) {
            // left subtree
            root.left = Insert(root.left, value);
        } else {
            // right subtree
            root.right = Insert(root.right, value);
        }
        return root;
    }

    public static void Inorder ( Node root) { 
        if( root == null) {
            return;
        }
        Inorder(root.left);
        System.out.print(root.data);
        Inorder(root.right);
    }
    public static void main(String[] args) { 
        int values [] = {5, 1, 3, 4, 2, 7};
        Node root = null; 

        for (int i=0; i<values.length; i++) {
            root = Insert(root, values[i]);
        }

        Inorder(root);
        System.out.println();
    }
    
}
