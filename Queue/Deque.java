import java.util.*;

public class MyDeque {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(2);

        System.out.println(deque);
        deque.addLast(3);
        deque.addLast(4);

        System.out.println(deque);
        System.out.println("First ele : "+ deque.getFirst());
        System.out.println("Last ele : "+ deque.getLast());

    }
}

