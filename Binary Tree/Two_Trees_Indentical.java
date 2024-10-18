public class Two_Trees_Indentical {
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

    class BinaryTree {
        Node root1, root2;
        boolean IndenticalTrees (Node root1, Node root2) {
            if( root1 == null && root2 == null) {
                return true;
            }
                if( root1 != null && root2 != null) {
                    return (root1.data == root2.data 
                    && IndenticalTrees(root1.left, root2.left)
                    && IndenticalTrees(root1.right, root2.right));
                }
            
            return true; 
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

        if( tree.IndenticalTrees(tree.root1, tree.root2)) 
            System.out.println(" Both trees are identical.");
        
        else 
            System.out.println(" Both trees are not identical");
        
        
    }
}
