package LinkedList.Questions;

import LinkedList.LLquestions;
// this file will give an error as we need to conn
public class LLcycle141 extends LLquestions {
        public boolean hasCycle(Node head) {
            Node temp = head;
            Node temp1 = head;

            if(head == null || temp1 == null || temp1.next == null) return false;   // creates checks for both as we need to move temp1 two steps

            while(temp1 != null && temp1.next != null){     // we need to move temp1 two steps
                temp = temp.next;
                temp1 = temp1.next.next;

                if(temp == temp1) return true;  // it means an overlap is found and they both point to the same node
        }
            return false;
        }

    // ******************************  TEST THE METHOD ON LEETCODE  *************************************
}
