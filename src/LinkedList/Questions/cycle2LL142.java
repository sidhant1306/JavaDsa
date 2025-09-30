package LinkedList.Questions;

import LinkedList.LLquestions;

public class cycle2LL142 extends LLquestions {
    public Node detectCycle(Node head){
        Node fast = head;
        Node slow = head;


        if(head == null || fast == null || fast.next == null) return null;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow){
                fast = head;        // if they meet at some point change the position of fast to head again
                // check visualization:
//                https://claude.ai/chat/39fb9132-5e69-4dad-b0c6-bfabb2c637c3

                while(fast != slow){
                    fast = fast.next;   // by moving them one by one they will meet again at some point that point will be the point of start
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }

    // check implementation on leetcode:
//    https://leetcode.com/problems/linked-list-cycle-ii/
}
