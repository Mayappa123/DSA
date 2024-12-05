//2337. Move Pieces to Obtain a String

// You are given two strings start and target, both of length n. 
//Each string consists only of the characters 'L', 'R', and '_' where:

// The characters 'L' and 'R' represent pieces, where a piece 'L' can move to the left only if there is a blank space directly to its left.
//A piece 'R' can move to the right only if there is a blank space directly to its right.
// The character '_' represents a blank space that can be occupied by any of the 'L' or 'R' pieces.
// Return true if it is possible to obtain the string target by moving the pieces of the string start any number of times. Otherwise, return false.

public class Move_Pieces_to_Obtain_a_String {
    public static boolean canChange(String start, String target) {
        if (start.equals(target)) {
            return true;
        }
        int waitL = 0;
        int waitR = 0;

        for (int i = 0; i < start.length(); i++) {
            char curr = start.charAt(i);
            char goal = target.charAt(i);

            if (curr == 'R') {
                if (waitL > 0) {
                    return false;
                }
                waitR++;
            }
            if (goal == 'L') {
                if (waitR > 0) {
                    return false;
                }
                waitL++;
            }
            if (goal == 'R') {
                if (waitR == 0) {
                    return false;
                }
                waitR--;
            }
            if (curr == 'L') {
                if (waitL == 0) {
                    return false;
                }
                waitL--;
            }
        }

        return waitL == 0 && waitR == 0;
    }

    public static void main(String[] args) {
        String start = "_L__R__R_";
        String target = "L______RR";

        System.out.println(canChange(start, target)); // true
    }
}
