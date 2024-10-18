import java.util.*;
public class Longest_word_with_all_Prefixes {
    static class Node {
        Node[]children = new Node[26];
        boolean eow;

        public Node() {
            for(int i=0; i<26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        int level = 0;
        int len = word.length();
        int idx = 0;

        Node curr = root;
        for(; level<len; level++) {
            idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];

        }
        curr.eow = true; 
    }

    public static boolean search (String key) {
        int level = 0;
        int len = key.length();
        int idx = 0;

        Node curr = root;
        for(; level<len; level++) {
            idx = key.charAt(level) - 'a';
            if(curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];

        }
        return curr.eow = true; 

    }
    public static String ans = "";
    public static void LongestWord (Node root, StringBuilder temp){
        if(root == null) {
            return;
        }

        for(int i=0; i<26; i++) {
            if(root.children[i] != null && root.children[i].eow == true) {
                char ch = (char)(i+'a');
                temp.append(ch);
                if(temp.length() > ans.length()) {
                    ans = temp.toString();
                }

                LongestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }


    public static void main(String[] args) {
        String words[] = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        for(int i=0; i<words.length; i++) {
            insert(words[i]);
        }
        LongestWord(root, new StringBuilder(""));
        System.out.println(ans);
        
    }
    
}
