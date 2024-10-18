public class Tree_Diameter {

    static class Node {
        int data;
        Node left, right;

        public Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
          
        }
    }

    public static int height (Node root) {
        if(root == null){
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) +1;

    }


    public static int Diameter ( Node root) {
        if(root == null) {
            return 0;
        }
        int leftdia = Diameter(root.left);
        int leftht = height(root.left);
        int rightdia = Diameter(root.right);
        int rightht = height(root.right);

        int selfdia = leftht + rightht + 1;

        return Math.max( selfdia, Math.max(leftdia, rightdia));
    }

    static class info {
        int dia;
        int ht;

        public info ( int dia, int ht) {
            this.dia = dia;
            this.ht = ht;
        }
    }

    public static info diameter( Node root) {
        if( root == null) {
            return new info(0, 0);
        }
         info leftinfo = diameter(root.left);
         info rightinfo = diameter(root.right);

         int dia = Math.max(Math.max(leftinfo.dia, rightinfo.dia), leftinfo.ht + rightinfo.ht + 1);
         int ht = Math.max (leftinfo.ht, rightinfo.ht) + 1;

         return new info(dia, ht);
    }
    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(Diameter(root));
        
    }
}
