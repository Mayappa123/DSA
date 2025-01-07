//1408. String Matching in an Array

// Given an array of string words, return all strings in words that is a substring of another word. 
//You can return the answer in any order.
// A substring is a contiguous sequence of characters within a string

import java.util.ArrayList;

public class String_Matching_in_an_Array {
    public static List<String> stringMatching(String[] words) {
        List<String> substrings = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && isSubstring(words[i], words[j])) {
                    substrings.add(words[i]);
                    break;
                }
            }
        }
        return substrings;
    }

    public static boolean isSubstring(String word, String otherWord) {
        return otherWord.contains(word);
    }

    public static void main(String[] args) {
        String[] words = { "mass", "as", "hero", "superhero" };

        System.out.println(stringMatching(words));

        // Input: words = ["mass","as","hero","superhero"]
        // Output: ["as","hero"]
        // Explanation: "as" is substring of "mass" and "hero" is substring of
        // "superhero".
        // ["hero","as"] is also a valid answer.
    }
}