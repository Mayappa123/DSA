import java.util.*;
public class Starts_with_Prefix {
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

    public static boolean StartsWith(String Prefix) {
        Node curr = root;
        
        for(int i=0; i<Prefix.length(); i++) {
            int Idx = Prefix.charAt(i) - 'a';
            if(curr.children[Idx] == null) {
                return false;
            }
            curr = curr.children[Idx];
        }
        return true;
    }



    public static void main(String[] args) {
        String words[] = {"app", "apple", "mango", "man", "woman"};
        String Prefix1 = "app";
        String Prefix2 = "moon";

        for(int i=0; i<words.length; i++) {
            insert(words[i]);
        }

        System.out.println(StartsWith(Prefix1));
        System.out.println(StartsWith(Prefix2));


        
    }
    
}
