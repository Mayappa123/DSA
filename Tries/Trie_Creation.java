import java.util.*;
public class Trie_Creation {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;

        Node() {
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
    public static void main(String[] args) {
        String words[] = {"the", "a", "there", "their", "any", "thee"};

        for(int i=0; i<words.length; i++) {
            insert(words[i]);
        }

        System.out.println(search("thee"));
        System.out.println(search("thor"));
    }
}
