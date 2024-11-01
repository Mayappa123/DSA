
// 1957. Delete Characters to Make Fancy String

// A fancy string is a string where no three consecutive characters are equal.
// Given a string s, delete the minimum possible number of characters from s to make it fancy.
// Return the final string after the deletion. It can be shown that the answer will always be unique.

public class Delete_Characters_to_Make_Fancy_String {
    public static String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        int count = 1; // count occurrences of the current character

        // Append the first character to the result
        result.append(s.charAt(0));

        // Iterate over the string starting from the second character
        for (int i = 1; i < s.length(); i++) {
            // If the current character is the same as the previous, increment the count
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                // Reset the count if the current character is different
                count = 1;
            }

            // Only add the current character if count is less than 3
            if (count < 3) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String fancyString = makeFancyString("LeeetCode");
        System.out.println(fancyString);
    }
}
