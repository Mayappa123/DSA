import java.util.ArrayList;

import javax.swing.tree.Node;

public class Largest_value_in_each_Row_in_BT {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    private List<Integer> res;

    public static List<Integer> largestValues(Node root) {
        res = new ArrayList<>();
        dfs(root, 0);

        return res;
    }

    public static void dfs(Node root, int level) {
        if (root != null) {
            int data = root.data;

            if (res.size() == level)
                res.add(data);
            else
                res.set(level, Math.max(res.get(level), data));

            dfs(root.left, level + 1);
            dfs(root.right, level + 1);
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(Arrays.toString(largestValues(root)));

    }

}
