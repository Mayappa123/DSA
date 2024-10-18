import java.util.*;

public class Stack_Using_Dq {

    static class Stack {
        Deque<Integer> dq = new LinkedList<>();

        public void push(int data) {
            dq.addLast(data);
        }

        public int pop() {
            return dq.removeLast();
        }

        public int peek() {
            return dq.getLast();
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("peek element is "+s.peek());

        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
