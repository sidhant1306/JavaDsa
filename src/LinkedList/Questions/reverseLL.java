package LinkedList.Questions;

import LinkedList.LLquestions;

public class reverseLL extends LLquestions {
    // explanation at the end...

    public void reverse(Node temp){
        if(temp == null || temp.next == null){
            head = temp;
            return;
        }

        reverse(temp.next);

        temp.next.next = temp;
        temp.next = null;
    }

    public void reverseLL2(Node temp){
        if(temp == tail){
            head = tail;
            return;
        }

        reverseLL2(temp.next);

        tail.next = temp;
        tail = temp;
        tail.next = null;
    }

        public Node reverseIterative(Node head){
            if(head == null || head.next == null){
                return head;
            }
            Node prev = null;
            Node present = head;
            Node forward = head.next;

            while(present != null){
                forward = present.next;
                present.next = prev;
                prev = present;
                present = forward;

            }
//            head = prev; // this won't work because
                          // Must assign the returned head because Java passes references by value.
                         // Changing 'head' inside the function only affects the local copy.
                        // Returning 'prev' and assigning it updates the actual list head.
                       // that is why we reassign the returned output of this function to the original head of rev class, in the main function while calling this function.

            return prev;
        }

    public static void main(String[] args) {
        reverseLL rev = new reverseLL();
        rev.insertFirst(88);
        rev.insertFirst(77);
        rev.insertFirst(33);
        rev.insertFirst(238);
//        rev.reverse(rev.head);
//        rev.reverseLL2(rev.head);
       rev.reverseIterative(rev.head);
        rev.display();
    }
}


/*
  =======================================================================================
  EXPLANATION OF THE RECURSIVE REVERSAL LOGIC
  =======================================================================================

  This function reverses a linked list using a "divide and conquer" recursive strategy.
  The core idea is to trust the recursion to handle reversing the *rest* of the list,
  while each function call only performs one small, specific job.

  The process can be broken down into two main phases:

  Phase 1: The Recursive "Dive" Down the Call Stack
  --------------------------------------------------
  When `reverse(temp)` is called, it first checks if it has reached the end of the list
  (the base case). If not, it does nothing but immediately call `reverse(temp.next)`.
  It essentially says, "I can't do my job until the entire list after me is reversed."
  This continues until the very last node is reached, creating a stack of paused function calls.

  - reverse(10) is called, pauses.
  - reverse(20) is called, pauses.
  - reverse(30) is called, pauses.
  - reverse(40) is called, pauses.
  - reverse(50) is called. It hits the base case.


  Phase 2: The Reversal on the "Unwind" from the Stack
  ----------------------------------------------------
  Once the base case is hit (at Node 50), the function calls start returning, or "unwinding".
  This is where the actual pointer reversal happens, from the end of the list back to the start.

  Let's trace the unwind from the deepest point:

  1. `reverse(Node 50)`:
  - Hits the base case (`temp.next` is null).
  - It sets the global `head` pointer to itself (Node 50).
  - It returns.

  2. `reverse(Node 40)` resumes:
  - It just received the return from `reverse(50)`. It trusts that the rest of the list is handled.
  - It executes `temp.next.next = temp;` which translates to `50.next = 40`. The first link is reversed.
  - It executes `temp.next = null;` which translates to `40.next = null`. This breaks the old forward link.
  - The list now looks like: ... -> 30 -> 40 <- 50 (head)
  - It returns.

  3. `reverse(Node 30)` resumes:
  - It trusts that the sub-list `40 -> 50` is now correctly reversed as `50 -> 40`.
  - It executes `temp.next.next = temp;` which becomes `40.next = 30`.
  - It executes `temp.next = null;` which becomes `30.next = null`.
  - The list now looks like: ... -> 20 -> 30 <- 40 <- 50 (head)
  - It returns.

  4. `reverse(Node 20)` resumes:
  - It executes `temp.next.next = temp;` which becomes `30.next = 20`.
  - It executes `temp.next = null;` which becomes `20.next = null`.
  - The list now looks like: 10 -> 20 <- 30 <- 40 <- 50 (head)
  - It returns.

  5. `reverse(Node 10)` (the initial call) resumes:
  - It executes `temp.next.next = temp;` which becomes `20.next = 10`.
  - It executes `temp.next = null;` which becomes `10.next = null`. This is crucial, as Node 10 is the new tail.
  - The function finishes.

  Final Result: The `head` pointer is at 50, and the list is fully reversed: 50 -> 40 -> 30 -> 20 -> 10.

 */