//3042. Count Prefix and Suffix Pairs I

// You are given a 0-indexed string array words.
// Let's define a boolean function isPrefixAndSuffix that takes two strings, str1 and str2:
// isPrefixAndSuffix(str1, str2) returns true if str1 is both a prefix and a suffix of str2, and false otherwise.
// For example, isPrefixAndSuffix("aba", "ababa") is true because "aba" is a prefix of "ababa" and also a suffix, but isPrefixAndSuffix("abc", "abcd") is false.
// Return an integer denoting the number of index pairs (i, j) such that i < j, and isPrefixAndSuffix(words[i], words[j]) is true.

public class Count_Suffix_and_Prefix_Pairs {

    public static boolean isPrefixAndSuffix(String str1, String str2) {
        int n1 = str1.length(), n2 = str2.length();
        if (n1 > n2) {
            return false;
        }
        return str2.substring(0, n1).equals(str1) && str2.substring(n2 - n1).equals(str1);
    }

    public static int countPrefixSuffixPairs(String[] words) {
        int n = words.length, count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] words = { "a", "aba", "ababa", "aa" };

        System.out.println(countPrefixSuffixPairs(words));

        // Input: words = ["a","aba","ababa","aa"]
        // Output: 4
        // Explanation: In this example, the counted index pairs are:
        //     i = 0 and j = 1 because isPrefixAndSuffix("a", "aba") is true.
        //     i = 0 and j = 2 because isPrefixAndSuffix("a", "ababa") is true.
        //     i = 0 and j = 3 because isPrefixAndSuffix("a", "aa") is true.
        //     i = 1 and j = 2 because isPrefixAndSuffix("aba", "ababa") is true.
        //     Therefore, the answer is 4.
    }
}
