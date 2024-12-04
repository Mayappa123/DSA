//2825. Make String a Subsequence Using Cyclic Increments

// You are given two 0-indexed strings str1 and str2.
//In an operation, you select a set of indices in str1, and for each index i in the set, increment str1[i] to the next character cyclically. 
//That is 'a' becomes 'b', 'b' becomes 'c', and so on, and 'z' becomes 'a'.
//Return true if it is possible to make str2 a subsequence of str1 by performing the operation at most once, and false otherwise.

//Note:A subsequence of a string is a new string that is formed from the original string by deleting some(possibly none)of the characters without disturbing the relative positions of the remaining characters.

public class Can_Make_Subsequence {

    public static boolean canMakeSubsequence(String source, String target) {
        int targetIdx = 0, targetLen = target.length();

        for (char currChar : source.toCharArray()) {
            if (targetIdx < targetLen && (target.charAt(targetIdx) - currChar + 26) % 26 <= 1) {
                targetIdx++;
            }
        }
        return targetIdx == targetLen;
    }

    public static void main(String[] args) {
        String str1 = "abc", str2 = "ad";

        System.out.println(canMakeSubsequence(str1, str2)); // true
    }
}
