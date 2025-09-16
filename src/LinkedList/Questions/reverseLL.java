package LinkedList.Questions;

import LinkedList.LLquestions;

public class reverseLL extends LLquestions {
    public Node reverse(Node head){
        Node temp = head;
        while(temp != null){
            temp = temp.next;
        }
        temp.next = head;
        while(temp != head){
            temp = temp.next;
        }
        return temp;
    }

    public static void main(String[] args) {
        reverseLL rev = new reverseLL();
        rev.insertFirst(88);
        rev.insertFirst(77);
        rev.insertFirst(33);
        Node ans = rev.reverse(rev.head);
        System.out.println(ans);
    }
}
