// 1910. Remove All Occurrences of a Substring
// Given two strings s and part, perform the following operation on s until all occurrences of the substring part are removed:
// Find the leftmost occurrence of the substring part and remove it from s.
// Return s after removing all occurrences of part.
// A substring is a contiguous sequence of characters in a string.

public class Remove_All_Occurances_of_SubString {
    public static String removeOccurrences(String s, String part) {
        char[] input = s.toCharArray();
        char[] target = part.toCharArray();
        char[] resultStack = new char[input.length];
        int stackSize = 0, targetLength = target.length;
        char targetEndChar = target[targetLength - 1];

        for (char currentChar : input) {
            resultStack[stackSize++] = currentChar;

            if (currentChar == targetEndChar && stackSize >= targetLength) {
                int i = stackSize - 1, j = targetLength - 1;

                while (j >= 0 && resultStack[i] == target[j]) {
                    i--;
                    j--;
                }

                if (j < 0) {
                    stackSize = i + 1;
                }
            }
        }
        return new String(resultStack, 0, stackSize);
    }

    public static void main(String[] args) {
        String s = "daabcbaabcbc", part = "abc";
        Sysytem.out.println(removeOccurrences(null, null));

        // Example 1:
        // Input: s = "daabcbaabcbc", part = "abc"
        // Output: "dab"
        // Explanation: The following operations are done:
        // - s = "daabcbaabcbc", remove "abc" starting at index 2, so s = "dabaabcbc".
        // - s = "dabaabcbc", remove "abc" starting at index 4, so s = "dababc".
        // - s = "dababc", remove "abc" starting at index 3, so s = "dab".
        // Now s has no occurrences of "abc".
    }
}
