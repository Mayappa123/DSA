// 1861. Rotating the Box

// You are given an m x n matrix of characters box representing a side-view of a box. Each cell of the box is one of the following:

// A stone '#'
// A stationary obstacle '*'
// Empty '.'
// The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity. 
//Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. 
//Gravity does not affect the obstacles' positions, and the inertia from the box's rotation does not affect the stones' horizontal positions.
// It is guaranteed that each stone in box rests on an obstacle, another stone, or the bottom of the box.
// Return an n x m matrix representing the box after the rotation described above.

public class Rotating_the_Box {

    public static char[][] rotateTheBox(char[][] box) {
        int m = box.length; // Number of rows
        int n = box[0].length; // Number of columns

        // Step 1: Apply gravity to make stones fall within the box
        for (int i = 0; i < m; i++) {
            int emptySpot = n - 1; // Track the nearest empty spot from the right

            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '#') {
                    // Move the stone to the nearest empty spot
                    box[i][j] = '.';
                    box[i][emptySpot] = '#';
                    emptySpot--;
                } else if (box[i][j] == '*') {
                    // Reset emptySpot as obstacle prevents stones from falling further
                    emptySpot = j - 1;
                }
            }
        }

        // Step 2: Rotate the box 90 degrees clockwise
        char[][] rotatedBox = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotatedBox[j][m - 1 - i] = box[i][j];
            }
        }

        return rotatedBox;
    }

    public static void main(String[] args) {
        char[][] box = { { '#', '.', '#' } };

        char[][] ans = rotateTheBox(box); // . # #

        for (char[] row : ans) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.print(" ");
        }

    }
}
