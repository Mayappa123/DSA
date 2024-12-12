//2558. Take Gifts From the Richest Pile

// You are given an integer array gifts denoting the number of gifts in various piles. 
//Every second, you do the following:

// Choose the pile with the maximum number of gifts.
// If there is more than one pile with the maximum number of gifts, choose any.
// Leave behind the floor of the square root of the number of gifts in the pile. Take the rest of the gifts.
// Return the number of gifts remaining after k seconds.

import java.util.*;

public class Take_Gifts_From_Richest_Pile {

    public static long pickGifts(int[] g, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int val : g)
            maxHeap.add(val);

        for (int i = 0; i < k && maxHeap.peek() > 1; i++) {
            int x = maxHeap.remove();
            maxHeap.add((int) Math.sqrt(x));
        }

        long sum = 0;
        for (int val : maxHeap)
            sum += val;

        return sum;
    }

    public static void main(String[] args) {
        int[] gifts = { 25, 64, 9, 4, 100 };
        int k = 4;

        System.out.println(pickGifts(gifts, k)); // 29
    }
}
