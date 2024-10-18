
import java.util.*;

public class Single_Linked_List1 {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    public void creation() {
        int data, n;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(" Enter data :  ");
            data = sc.nextInt();
            Node New_Node = new Node(data);
            if (head == null) {
                head = New_Node;
            }

            else {
                New_Node.next = head;
                head = New_Node;
            }

            System.out.println(" Do you want to add more data ? If yes, please press 1. ");
            n = sc.nextInt();
        } while (n == 1);

        sc.close();

    }

    public void traverse() {
        Node temp = head;
        if (head == null) {
            System.out.println(" Linked_List does not exists.");
        } else {
            while (temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }

        }

    }

    public static void main(String[] args) {
        Single_Linked_List1 l1 = new Single_Linked_List1();
        l1.creation();
        l1.traverse();

    }
}
