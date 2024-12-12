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
