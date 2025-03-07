import java.util.*;
public class Word_Break_Problem {

    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

       public Node() {
            for(int i=0; i<26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();
    
    // Insertion
    public static void insert(String word) {
        Node curr = root;
        for( int level=0; level<word.length(); level++) {
            int Idx = word.charAt(level) - 'a';
            if(curr.children[Idx] == null) {
                curr.children[Idx] = new Node();
            }
            curr = curr.children[Idx];

        }
        curr.eow = true;
    }

    // Search
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

    public static boolean wordbreak (String key) {
        if(key.length() == 0) {
            return true;
        }
        for(int i=1; i<=key.length(); i++) {
            if(search(key.substring(0, i)) && wordbreak(key.substring(i))) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {

        String arr[] = {"i", "like", "sam", "samsung", "mobile", "ice"};
        for(int i=0; i<arr.length; i++) {
            insert(arr[i]);
        }

        String key = "ilikesung";
        System.out.println(wordbreak(key));
        
    }
}
