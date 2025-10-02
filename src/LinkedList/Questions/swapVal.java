package LinkedList.Questions;

import LinkedList.LLquestions;

public class swapVal extends LLquestions {

    public Node swap(Node head, int k) {
        int size = 1;
        int i = 1;
        Node temp = head;

        while (temp != null) {
            temp = temp.next;
            size++;
            i++;
        }

        Node left = head;
        Node right = head;
        int j = 1;
        int s = 1;

        while (j < k) {
            left = left.next;
            j++;
        }

        while (s < (size - k)) {
            right = right.next;
            s++;
        }

        int value = right.value;

        right.value = left.value;
        left.value = value;

        return head;
    }

    public static void main(String[] args) {
        swapVal swapval = new swapVal();
        swapval.insertFirst(5);
        swapval.insertFirst(4);
        swapval.insertFirst(3);
        swapval.insertFirst(2);
        swapval.insertFirst(1);
        swapval.display();
        System.out.println("swapping");
        swapval.swap(swapval.head, 2);
        swapval.display();
    }
}
