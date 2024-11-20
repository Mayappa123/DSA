//2516. Take K of Each Character From Left and Right

// You are given a string s consisting of the characters 'a', 'b', and 'c' and a non-negative integer k. 
//Each minute, you may take either the leftmost character of s, or the rightmost character of s.
// Return the minimum number of minutes needed for you to take at least k of each character, or 
//Return -1 if it is not possible to take k of each character.

public class K_of_Each_character_from_Left_to_Right {

    public static int takeCharacters(String s, int k) {
        int n = s.length();
        int[] count = new int[3];

        // Count the total occurrences of each character in the string
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        // If any character has fewer than k occurrences, return -1
        if (count[0] < k || count[1] < k || count[2] < k) {
            return -1;
        }

        // Sliding window to find the largest valid substring
        int[] currentCount = new int[3];
        int start = 0, maxValidLength = 0;

        for (int end = 0; end < n; end++) {
            currentCount[s.charAt(end) - 'a']++;

            // Check if the window violates the constraint (needs to leave at least `k` of
            // each character outside)
            while (currentCount[0] > count[0] - k ||
                    currentCount[1] > count[1] - k ||
                    currentCount[2] > count[2] - k) {
                currentCount[s.charAt(start) - 'a']--;
                start++;
            }

            // Update the maximum valid window size
            maxValidLength = Math.max(maxValidLength, end - start + 1);
        }

        // Total minutes required are the characters outside the largest valid window
        return n - maxValidLength;
    }

    public static void main(String[] args) {

        String s = "aabaaaacaabc";
        int k = 2;

        System.out.println(takeCharacters(s, k)); // 8

    }
}
