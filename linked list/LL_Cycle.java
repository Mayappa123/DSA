public class LL_Cycle {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static boolean Cycle_LL(Node head) {
        if  (head == null) {
            return true;
        }
        Node slow = head;
        Node fast = head;

        while  (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if  (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        boolean hasCycle = Cycle_LL(head);

        System.out.println(hasCycle ? "Cycle exists in the linked list." : "No cycle in the linked list.");
    }
}

