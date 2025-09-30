package LinkedList.Questions;

import LinkedList.LLquestions;

public class removeElements203 extends LLquestions {
   public Node removeElem(Node head, int val){

       while(head != null && head.value == val){
           head = head.next;        // we are removing all the nodes present in the starting of the linked list with the target value
       }

       Node temp = head;
       while(temp != null && temp.next != null){
           if(temp.next.value == val){
               temp.next = temp.next.next;
           }
           else{
               temp = temp.next;
           }
       }
       return head;
   }

    public static void main(String[] args) {
        removeElements203 rem = new removeElements203();

        rem.insertFirst(22);
        rem.insertFirst(89);
        rem.insertFirst(238);
        rem.insertFirst(6);
        rem.insertFirst(66);
        rem.insertFirst(6);
        rem.insertFirst(88);
        rem.insertFirst(6);

        rem.display();
        rem.head = rem.removeElem(rem.head, 6);
        rem.display();
    }
}
