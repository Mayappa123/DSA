import java.util.*;
public class Unique_SubString {

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

    public static boolean search(String key) {
        Node curr = root;
        for(int level=0; level<key.length(); level++) {
            int Idx = key.charAt(level) - 'a';
            if(curr.children[Idx] == null) {
                return false;
            }
            else {
                curr = curr.children[Idx];
            }
        }
        return curr.eow = true;
    }

    public static int CountNode(Node root) {
        if(root == null) {
            return 0;
        }
        int count = 0;
        for(int i=0; i<26; i++) {
            if(root.children[i] != null) {
                count += CountNode(root.children[i]);
            }
        }
        return count+1;
    }

    public static void main(String[] args) {

        String str = "ababa";
        for(int i=0; i<str.length(); i++) {
            String suffix = str.substring(i);
            insert(suffix);
        }

        System.out.println(CountNode(root));
        
    }
    
}
