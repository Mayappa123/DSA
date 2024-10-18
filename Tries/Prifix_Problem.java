import java.util.*;
public class Prifix_Problem {
    
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;
        int freq;

        public Node() {
            for(int i=0; i<children.length; i++) {
                children[i] = null;
            }
            freq = 1;
        }
    }
    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;
        for(int i=0; i<word.length(); i++) {
            int Idx = word.charAt(i) - 'a';
            if(curr.children[Idx] == null) {
                curr.children[Idx] = new Node();
            }
            else {
                curr.children[Idx].freq++;
            }
            curr = curr.children[Idx];
        }
        curr.eow = true;
        
    }

    public static void findPrefix(Node root, String ans) {
        if(root == null) {
            return;
        }
        if(root.freq == 1) {
            System.out.println(ans);
            return;
        }
        for(int i=0; i<root.children.length; i++) {
            if(root.children[i] != null) {
                findPrefix(root.children[i], ans+(char)(i+'a'));
            }
        }
            
    }
    public static void main(String[] args) {
        String arr[] = {"zebra", "dog", "duck", "dove"};
        for(int i=0; i<arr.length; i++) {
            insert(arr[i]);
        }
        root.freq = -1;

        findPrefix(root, "");
        
    }
    
}
