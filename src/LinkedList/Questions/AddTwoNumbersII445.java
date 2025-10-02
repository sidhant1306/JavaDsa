package LinkedList.Questions;

import LinkedList.LLquestions;

public class AddTwoNumbersII445 extends LLquestions {
    public Node addTwoNumbersTwo(Node temp1, Node temp2){

        Node first = reverse(temp1);        // at first we need to reverse the linked lists
        Node second = reverse(temp2);

        Node dummy = new Node(0);
        Node curr = dummy;

        int carry = 0;

        while(first != null || second != null || carry != 0){
            int val1 = first != null ? first.value : 0;
            int val2 = second != null ? second.value : 0;

            int currSum = val1 + val2 + carry;

            carry = currSum / 10;
            int ans = currSum % 10;

            curr.next = new Node(ans);
            curr = curr.next;

            if(first != null) first = first.next;
            if(second != null) second = second.next;
        }
        return reverse(dummy.next);     // returned the reversed answer because we added them after reversing them
    }

    public Node reverse(Node head){

        if(head == null || head.next == null){
            return head;
        }

        Node curr = head;
        Node prev = null;
        Node forward = head.next;

        while(curr != null){
            forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        return prev;
    }
}
