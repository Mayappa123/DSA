//2109. Adding Spaces to a String

// You are given a 0-indexed string s and a 0-indexed integer array spaces that describes the indices in the original string where spaces will be added. 
//Each space should be inserted before the character at the given index.

// For example, given s = "EnjoyYourCoffee" and spaces = [5, 9], we place spaces before 'Y' and 'C', which are at indices 5 and 9 respectively. 
//Thus, we obtain "Enjoy Your Coffee".
// Return the modified string after the spaces have been added.

public class Adding_Spaces_to_String {

    public static String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();

        sb.append(s.substring(0, spaces[0]));
        int i = 1;
        for (; i < spaces.length; i++) {
            sb.append(" ");
            sb.append(s.substring(spaces[i - 1], spaces[i]));
        }
        sb.append(" ");
        sb.append(s.substring(spaces[i - 1]));

        return sb.toString();
    }

    public static void main(String[] args) {

        String s = "LeetcodeHelpsMeLearn";
        int[] spaces = { 8, 13, 15 };
        System.out.println(addSpaces(s, spaces)); // Leetcode Helps Me Learn

    }
}
