import javax.management.modelmbean.ModelMBeanAttributeInfo;

import java.util.*;

public class Merge_2_BST {

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

    public static void getInorder(Node root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }

        getInorder(root.left, arr);
        arr.add(root.data);
        getInorder(root.right, arr);

    }

    public static Node createBST(ArrayList<Integer> arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(arr.get(mid));
        root.left = createBST(arr, start, mid - 1);
        root.right = createBST(arr, mid + 1, end);
        return root;
    }

    public static Node mergeBST(Node root1, Node root2) {
        // step 1
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        getInorder(root1, arr1);

        // step 2
        ArrayList<Integer> arr2 = new ArrayList<Integer>();
        getInorder(root2, arr2);

        // merge
        int i = 0, j = 0;
        ArrayList<Integer> finalarr = new ArrayList<Integer>();
        while (i < arr1.size() && j < arr2.size()) {
            if (arr1.get(i) <= arr2.get(j)) {
                finalarr.add(arr1.get(i));
                i++;
            } else {
                finalarr.add(arr2.get(j));
                j++;
            }

        }

        while (i < arr1.size()) {
            finalarr.add(arr1.get(i));
            i++;

        }

        while (j < arr2.size()) {
            finalarr.add(arr2.get(j));
            j++;
        }

        // sorted AL -> Balanced BST
        return createBST(finalarr, 0, finalarr.size() - 1);

    }

    public static void PreOrder(Node root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.data + " ");
            PreOrder(root.left);
            PreOrder(root.right);
        }
    }

    public static void main(String[] args) {

        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2 = new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root = mergeBST(root1, root2);
        PreOrder(root);

    }
}
