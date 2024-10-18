import java.util.*;

import arrays.Arraylist;
public class Convert_BST_to_Balanced_BST { 
    static class Node {
        int data;
        Node left;
        Node right;

        public Node( int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

     public static void PreOrder (Node root) {
        if(root == null) {
            return;
        } 
        System.out.print(root.data+" ");
        PreOrder(root.left);
        PreOrder(root.right);
     } 

     public static void GetInOrder(Node root, ArrayList<Integer> InOreder) {
        if( root == null) {
            return;
        } 
        GetInOrder(root.left, InOreder);
        InOreder.add(root.data);
        GetInOrder(root.right, InOreder);
     }

     public static Node CreateBST (ArrayList<Integer> InOrder, int strt, int end) {
        if( strt > end ) {
            return null;
        } 
        int mid = (strt + end)/2;
        Node root = new Node(InOrder.get(mid));
        root.left = CreateBST(InOrder, strt, mid-1);
        root.right = CreateBST(InOrder, mid+1, end);
        return root;
     }
      
     public static Node BalanceBST(Node root) {
        // InOrder Sequence
        ArrayList<Integer> inorder = new ArrayList<Integer>();
        GetInOrder(root, inorder);

        // Sorted ArrayList --> Balanced BST
        root = CreateBST(inorder, 0, inorder.size()-1);
        return root;
     }

     
     public static void main(String[] args) {
        Node root = new Node(8);
        root.left  = new Node(6);
        root.left.left  = new Node(5);
        root.left.left.left  = new Node(3);

        root.right  = new Node(10);
        root.right.right  = new Node(11);
        root.right.right.right  = new Node(12);

        root = BalanceBST(root);
        PreOrder(root);



     }
    
}
