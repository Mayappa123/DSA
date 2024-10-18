import java.util.*;

public class Kth_Ancestor {
    public static void main(String[] args) {
         static class Node {
            int data;
            Node left;
            Node right;

            public Node ( int data) {
                this.data = data;
                this.left = null;
                this.right = null;
            }

            public static int KAncestor ( Node root, int n, int k) {
                if( root == null) {
                    return -1;
                }
                if( root.data == n) {
                    return 0;
                } 
                int leftdist = KAncestor(root.left, n, k);
                int rightdist = KAncestor(root.right, n, k);
            }
         }
    }
}
