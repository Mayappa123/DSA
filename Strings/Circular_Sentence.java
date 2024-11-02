//2490. Circular Sentence

// A sentence is a list of words that are separated by a single space with no leading or trailing spaces.

// For example, "Hello World", "HELLO", "hello world hello world" are all sentences.
// Words consist of only uppercase and lowercase English letters. Uppercase and lowercase English letters are considered different.

// A sentence is circular if:

// The last character of a word is equal to the first character of the next word.
// The last character of the last word is equal to the first character of the first word.
// For example, "leetcode exercises sound delightful", "eetcode", "leetcode eats soul" are all circular sentences. However, "Leetcode is cool", "happy Leetcode", "Leetcode" and "I like Leetcode" are not circular sentences.

// Given a string sentence, return true if it is circular. Otherwise, return false.

public class Circular_Sentence {
    public static boolean isCircularSentence(String sentence) {
        String[] words = s.split(" ");

        for (int i = 0; i < words.length; i++) {
            char lastChar = words[i].charAt(words[i].length() - 1);
            char firstChar = words[(i + 1) % words.length].charAt(0);

            if (lastChar != firstChar) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        boolean isCircular = isCircularSentence("aman not talking");
        System.out.println(isCircular);
    }
}