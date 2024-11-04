// 3163. String Compression III

// Given a string word, compress it using the following algorithm:

// Begin with an empty string comp. While word is not empty, use the following operation:
// Remove a maximum length prefix of word made of a single character c repeating at most 9 times.
// Append the length of the prefix followed by c to comp.
// Return the string comp.

public class String_Compression_III {
    public static String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int count = 1, n = word.length();
        char ch = word.charAt(0);
        for (int i = 1; i < n; i++) {
            if (word.charAt(i) == ch && count < 9) {
                count++;
            } else {
                comp.append(count).append(ch);
                ch = word.charAt(i);
                count = 1;
            }
        }
        comp.append(count).append(ch);
        return comp.toString();
    }

    public static void main(String[] args) {
        System.out.println(compressedString("abcde")); // Output: "a1b1c1d1e1
    }
}
