import java.util.*;

public class Main {

    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student p2) {
            return this.rank - p2.rank;
        }

    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(3);
        pq.add(2);
        pq.add(1);
        pq.add(5);
        pq.add(4);

        while (!pq.isEmpty()) {
            System.out.print(pq.peek() + " ");
            pq.remove();
        }
        System.out.println();

        PriorityQueue<Student> s = new PriorityQueue<>(Comparator.reverseOrder());
        s.add(new Student("A", 15));
        s.add(new Student("B", 7));
        s.add(new Student("C", 2));
        s.add(new Student("D", 5));
        s.add(new Student("E", 45));

        while (!s.isEmpty()) {
            System.out.println(s.peek().name + "  --> rank " + s.peek().rank);
            s.remove();
        }
    }
}
