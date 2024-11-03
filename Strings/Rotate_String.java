//796. Rotate String
// Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

// s1 shift on s consists of moving the leftmost character of s to the rightmost position.

// For example, if s = "abcde", then it will be "bcdea" after one shift.

//Input: s = "abcde", goal = "cdeab"   Output: true
//Input: s = "abcde", goal = "abced"   Output: false

public class Rotate_String {

    public static boolean rotateString(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }

        if (s1.length() == 0) {
            return true;
        }
        for (int i = 0; i < s1.length(); i++) {
            if (rotateString(s1, s2, i)) {
                return true;
            }
        }
        return false;
    }

    public static boolean rotateString(String s1, String s2, int n) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt((i + n) % s2.length())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean canRotate = rotateString("abcde", "bcdea");
        System.out.println(canRotate);
    }
}