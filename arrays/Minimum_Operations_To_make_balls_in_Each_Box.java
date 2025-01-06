//1769. Minimum Number of Operations to Move All Balls to Each Box

// You have n boxes. You are given a binary string boxes of length n, where boxes[i] is '0' if the ith box is empty, and '1' if it contains one ball.
// In one operation, you can move one ball from a box to an adjacent box. Box i is adjacent to box j if abs(i - j) == 1. 
//Note that after doing so, there may be more than one ball in some boxes.
// Return an array answer of size n, where answer[i] is the minimum number of operations needed to move all the balls to the ith box.
// Each answer[i] is calculated considering the initial state of the boxes.

public class Minimum_Operations_To_make_balls_in_Each_Box {
    public static int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] distances = new int[n];

        int prefixCount = 0;
        int prefixSum = 0;

        for (int i = 0; i < n; ++i) {
            distances[i] = prefixCount * i - prefixSum;
            if (boxes.charAt(i) == '1') {
                ++prefixCount;
                prefixSum += i;
            }
        }

        int suffixCount = 0;
        int suffixSum = 0;

        for (int i = n - 1; i >= 0; --i) {
            distances[i] += suffixSum - suffixCount * i;
            if (boxes.charAt(i) == '1') {
                ++suffixCount;
                suffixSum += i;
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        String boxex = "110";
        System.out.println(minOperations(boxex));

        // Input: boxes = "110"
        // Output: [1,1,3]
        
        // Explanation: The answer for each box is as follows:
        // 1) First box: you will have to move one ball from the second box to the first
        // box in one operation.
        // 2) Second box: you will have to move one ball from the first box to the
        // second box in one operation.
        // 3) Third box: you will have to move one ball from the first box to the third
        // box in two operations, and move one ball from the second box to the third box
        // in one operation.

    }
}
