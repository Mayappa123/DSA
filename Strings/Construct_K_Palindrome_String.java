//1400. Construct K Palindrome Strings
//Given a string s and an integer k,return true if you can use all the characters in s to construct k palindrome strings or false otherwise.

import java.util.Arrays;

public class Construct_K_Palindrome_String {
    public static boolean canConstruct(String s, int k) {
        if (s.length() < k)
            return false;

        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        int oddCount = 0;

        for (int i = 0; i < chars.length;) {
            char current = chars[i];
            int count = 0;
            while (i < chars.length && chars[i] == current) {
                count++;
                i++;
            }
            if (count % 2 != 0)
                oddCount++;
        }

        return oddCount <= k;
    }

    public static void main(String[] args) {
        String s = "annabelle";
        int k = 2;

        System.out.println(canConstruct(s, k));

        // Input: s = "annabelle", k = 2
        // Output: true
        // Explanation: You can construct two palindromes using all characters in s.
        // Some possible constructions "anna" + "elble", "anbna" + "elle", "anellena" +
        // "b"
    }
}
