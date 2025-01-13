//3223. Minimum Length of String After Operations

// You are given a string s.
// You can perform the following process on s any number of times:
// Choose an index i in the string such that there is at least one character to the left of index i that is equal to s[i], and at least one character to the right that is also equal to s[i].
// Delete the closest character to the left of index i that is equal to s[i].
// Delete the closest character to the right of index i that is equal to s[i].
// Return the minimum length of the final string s that you can achieve.

public class Minimum_Length_of_Operation_after_Operation {
    public static int minimumLength(String s) {
        int[] charFrequency = new int[26];
        int totalLength = 0;
        for (char c : s.toCharArray()) {
            charFrequency[c - 'a']++;
        }
        for (int frequency : charFrequency) {
            if (frequency == 0)
                continue;
            if (frequency % 2 == 0) {
                totalLength += 2;
            } else {
                totalLength += 1;
            }
        }
        return totalLength;
    }

    public static void main(String[] args) {
        String s = "abaacbcbb";
        System.out.println(minimumLength(s));

        // Input: s = "abaacbcbb"
        // Output: 5
        // Explanation:
        // We do the following operations:
        // Choose index 2, then remove the characters at indices 0 and 3. The resulting
        // string is s = "bacbcbb".
        // Choose index 3, then remove the characters at indices 0 and 5. The resulting
        // string is s = "acbcb".
    }
}
