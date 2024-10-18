import java.util.*;

public class Print_Range {
    // Java program to print BST in given range

// A binary tree node
class Node {

	int data;
	Node left, right;

	Node(int d) {
		data = d;
		left = right = null;
	}
}

class BinaryTree {
	
	static Node root;
	
	/* The functions prints all the keys which in
	the given range [k1..k2]. The function assumes than k1 < k2 */
	void Print(Node node, int k1, int k2) {
		
		/* base case */
		if (node == null) {
			return;
		}

		/* Since the desired o/p is sorted, recurse for left subtree first
		If root->data is greater than k1, then only we can get o/p keys
		in left subtree */
		if (k1 < node.data) {
			Print(node.left, k1, k2);
		}

		/* if root's data lies in range, then prints root's data */
		if (k1 <= node.data && k2 >= node.data) {
			System.out.print(node.data + " ");
		}

		/* recursively call the right subtree */
		Print(node.right, k1, k2);
	}
	
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		int k1 = 10, k2 = 25;
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.right = new Node(22);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);

		tree.Print(root, k1, k2);
	}
}

// This code has been contributed by Mayank Jaiswal

}
