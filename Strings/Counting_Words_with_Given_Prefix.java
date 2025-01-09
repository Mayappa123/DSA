//2185. Counting Words With a Given Prefix

// You are given an array of strings words and a string pref.
// Return the number of strings in words that contain pref as a prefix.
// A prefix of a string s is any leading contiguous substring of s.

public class Counting_Words_with_Given_Prefix {
    public static int prefixCount(String[] words, String prefix) {
        int count = 0;

        for (String word : words) {
            if (word.startsWith(pref)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] words = { "pay", "attention", "practice", "attend" };
        String prefix = "at";

        System.out.println(prefixCount(words, prefix));

        // Input: words = ["pay","attention","practice","attend"], pref = "at"
        // Output: 2
        // Explanation: The 2 strings that contain "at" as a prefix are: "attention" and "attend".
    }
}
