package LinkedList.Questions;

import LinkedList.LLquestions;

public class RemoveNnode19 extends LLquestions {

    public Node removeN(Node head, int n){
        if(head == null || head.next == null) return null;      // if there is only one element return null

        Node temp = head;
        int length = 0;     // count the number of elements in the linked list
        while(temp != null){
            temp = temp.next;
            length++;
        }
        if(length == n) {       // if we have to delete the head then just move head to the next one and return it
            head = head.next;
            return head;
        }
        Node node = head;
        int i = 1;          // it will stop just one element before the element we want to delete
        while(i != (length - n)){
            node = node.next;
            i++;
        }
        if(n == 1) node.next = null;        // if we want to delete the last element
        else node.next = node.next.next;

        return head;
    }

    public static void main(String[] args) {
        RemoveNnode19 rem = new RemoveNnode19();

        rem.insertFirst(5);
        rem.insertFirst(4);
        rem.insertFirst(3);
        rem.insertFirst(2);
        rem.insertFirst(1);

        rem.removeN(rem.head, 2);
        rem.display();
    }
}
