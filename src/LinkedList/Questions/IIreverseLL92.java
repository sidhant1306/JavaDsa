package LinkedList.Questions;

import LinkedList.LLquestions;

public class IIreverseLL92 extends LLquestions {
    public Node reverseBetween(Node head, int left, int right) {
        if(head == null || head.next == null  || left == right) return head;

       Node dummy = new Node(0);       //dummy(0) → 3 → 2 → 1 → 4 → 5
        dummy.next = head;                   // so dummy.next always points to the original head even if the reversal takes place
        Node curr = head;
        Node temp = head;
        Node prev = dummy;  // always one position before curr

        // move curr and prev
        for (int i = 1; i < left; i++) {
            prev = curr;
            curr = curr.next;
        }

        for (int i = 0; i < right - left; i++) {
            temp = curr.next;       // node to move to front of sublist
            curr.next = temp.next;  // remove temp from its current position
            temp.next = prev.next;  // insert temp immediately after prev
            prev.next = temp;       // update prev to point to new front of sublist
        }
        return dummy.next;

    }

    public static void main(String[] args) {
        IIreverseLL92 rev = new IIreverseLL92();

        rev.insertFirst(5);
        rev.insertFirst(4);
        rev.insertFirst(3);
        rev.insertFirst(2);
        rev.insertFirst(1);
        rev.display();
        System.out.println("reversing:");
        rev.reverseBetween(rev.head, 2, 4);
        rev.display();
    }
}
