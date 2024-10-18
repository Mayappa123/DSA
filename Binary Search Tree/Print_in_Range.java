public class Print_in_Range { 
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

    public static void printInRange( Node root, int k1, int k2 ) {
        if(root == null) {
            return;
        }
        if( root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printInRange(root.right, k1, k2);
        }
        else if( root.data < k1 ) {
            printInRange(root.left, k1, k2);
        }
        else {
            printInRange(root.right, k1, k2);
        }
    }
    
    // public static Node InorderSuccessor( Node root) { 
    //     while(root.left != null) { 
    //         root = root.left;
    //     } 
    //      return root;
    // }

    public static void main(String[] args) {
        int values [] = {5, 1, 3, 4, 2,7};
        Node root = null;
       printInRange(root, 3, 5);
    }
}
