
//2381. Shifting Letters II
// You are given a string s of lowercase English letters and a 2D integer array shifts where shifts[i] = [starti, endi, directioni]. 
//For every i, shift the characters in s from the index starti to the index endi (inclusive) forward if directioni = 1, or shift the characters backward if directioni = 0.
// Shifting a character forward means replacing it with the next letter in the alphabet (wrapping around so that 'z' becomes 'a'). Similarly, shifting a character backward means replacing it with the previous letter in the alphabet (wrapping around so that 'a' becomes 'z').
// Return the final string after all such shifts to s are applied.

public class Shifting_Letters_II {
    public static String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] shift = new int[n + 1];

        for (int[] shiftOp : shifts) {
            int start = shiftOp[0], end = shiftOp[1], direction = shiftOp[2];
            shift[start] += (direction == 1 ? 1 : -1);
            if (end + 1 < n)
                shift[end + 1] -= (direction == 1 ? 1 : -1);
        }

        int currentShift = 0;
        for (int i = 0; i < n; ++i) {
            currentShift += shift[i];
            shift[i] = currentShift;
        }

        StringBuilder result = new StringBuilder(s);
        for (int i = 0; i < n; ++i) {
            int netShift = (shift[i] % 26 + 26) % 26;
            result.setCharAt(i, (char) ('a' + (s.charAt(i) - 'a' + netShift) % 26));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "abc";
        int[][] shifts = { { 0, 1, 0 }, { 1, 2, 1 }, { 0, 2, 1 } };
        System.out.println(sshiftingLetters(s, shifts));

        // Input: s = "abc", shifts = [[0,1,0],[1,2,1],[0,2,1]]
        // Output: "ace"
        // Explanation: Firstly, shift the characters from index 0 to index 1 backward.
        // Now s = "zac".
        // Secondly, shift the characters from index 1 to index 2 forward. Now s =
        // "zbd".
        // Finally, shift the characters from index 0 to index 2 forward. Now s = "ace".
    }
}
