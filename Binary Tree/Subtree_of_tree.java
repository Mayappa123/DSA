
public class Subtree_of_tree {

    static class Node {
        int data;
        Node left, right;

        public Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
          
        }
    }

    public static boolean Isidentical( Node node, Node subRoot) {
        if( node == null && subRoot == null ) {
            return true; 
        }
        else if ( node == null || subRoot == null || node.data != subRoot.data ) {
            return false;
        }
        if (!Isidentical(node.left, subRoot.left)) {
            return false;
        }
        if (!Isidentical(node.right, subRoot.right)) {
            return false;
        }
        return true;
    }

    public static boolean Issubtree( Node root, Node subRoot) {
        if ( root == null ) {
            return false;
        }

        if( root.data == subRoot.data) {
            if( Isidentical( root, subRoot)) {
                return true;
            }
        }
                return Issubtree(root, subRoot) || Issubtree(root, subRoot);
                
    }

    public static void main(String[] args) {
        
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node subroot = new Node(2);
        subroot.left = new Node(4);
        subroot.right = new Node(5);

        System.out.println( Issubtree(root, subroot));
            
        
    }
    
}
