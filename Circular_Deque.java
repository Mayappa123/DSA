public class Circular_Deque {

    private int count;
    private int n;
    private Node front;
    private Node rear;

    public Circular_Deque(int n) {
        this.count = 0;
        this.n = n;
        this.front = null;
        this.rear = null;
    }

    private class Node {
        int value;
        Node prev;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        Node newNode = new Node(value);
        if (front == null && rear == null) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
        count++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        Node newNode = new Node(value);
        if (front == null && rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }
        count++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        if (front == rear) {
            front = rear = null;
        } else {
            front = front.next;
            front.prev = null;
        }
        count--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if (front == rear) {
            front = rear = null;
        } else {
            rear = rear.prev;
            rear.next = null;
        }
        count--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return front.value;
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return rear.value;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == n;
    }

    public int getSize() {
        return count;
    }

    public static void main(String[] args) {
        Circular_Deque obj = new Circular_Deque(7);

        System.out.println(obj.insertFront(1));
        System.out.println(obj.getFront());
        System.out.println(obj.insertLast(2));
        System.out.println(obj.getRear());
        System.out.println("Deque has " + obj.getSize() + " elements.");
    }
}
