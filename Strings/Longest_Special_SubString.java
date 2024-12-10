//2981. Find Longest Special Substring That Occurs Thrice I

import java.util.HashMap;
public class Longest_Special_SubString {

    public static int maximumLength(String s) {
        // Map to store frequency of each special substring
        HashMap<String, Integer> substringCount = new HashMap<>();
        
        int n = s.length();
        
        // Generate all special substrings
        for (int i = 0; i < n; i++) {
            char currentChar = s.charAt(i);
            StringBuilder specialSubstring = new StringBuilder();
            
            for (int j = i; j < n; j++) {
                // Check if the current character matches
                if (s.charAt(j) == currentChar) {
                    specialSubstring.append(currentChar);
                    String specialStr = specialSubstring.toString();
                    substringCount.put(specialStr, substringCount.getOrDefault(specialStr, 0) + 1);
                } else {
                    break; // Stop as soon as we encounter a different character
                }
            }
        }
        
        // Find the longest special substring that occurs at least three times
        int maxLength = -1;
        for (String key : substringCount.keySet()) {
            if (substringCount.get(key) >= 3) {
                maxLength = Math.max(maxLength, key.length());
            }
        }
        
        return maxLength;
    }
    public static void main(String[] args) {
        String s = "aabccdeeee";

        System.out.println(maximumLength(s)); //2
    }
}
