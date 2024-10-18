package Heap;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Priority_Q { 
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(3);
        pq.add(1);
        pq.add(4);
        pq.add(7);

        while(!pq.isEmpty()) {
        System.out.println(pq.peek());
        pq.remove();
    }
}
    
}
