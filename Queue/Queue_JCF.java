import java.util.*;
//In java queue is implemented using only 2 classes i.e. LinkedList class and ArrayDeque class.
public class Queue_JCF {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);

        while(!q.isEmpty()) {
            System.out.print(q.peek()+" ");
            q.remove();
        }
    }
}
