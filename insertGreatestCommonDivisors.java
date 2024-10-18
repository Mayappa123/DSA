package DSA;

class insertGreatestCommonDivisors {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public Node insertGCD(Node head) {
        if (head.next == null) {
            return head;
        }
        Node node1 = head;
        Node node2 = head.next;

        while (node2 != null) {
            int gcdValue = calculateGCD(node1.data, node2.data);
            Node gcdNode = new Node(gcdValue);

            node1.next = gcdNode;
            gcdNode.next = node2;

            node1 = node2;
            node2 = node2.next;

        }
        return head;
    }

    private int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node head = new Node(36);
        head.next = new Node(60);
        head.next.next = new Node(48);
        head.next.next.next = new Node(72);

        insertGreatestCommonDivisors list = new insertGreatestCommonDivisors();

        System.out.println("Original list:");
        printList(head);

        head = list.insertGCD(head);

        System.out.println("Modified list with GCDs inserted:");
        printList(head);

    }

}