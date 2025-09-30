package LinkedList.Questions;

import LinkedList.LLquestions;

public class PalindromeLL extends LLquestions {

    Node temp;
    // We don’t pass 'temp' as a function argument or update it locally because:
    // 1. If we pass it as an argument, each recursive call would get its own copy of 'temp'.
    //    So when the recursion backtracks, the updates to 'temp' in deeper calls won’t reflect in the outer calls.
    // 2. If we update a local 'temp' inside the function, its scope is limited to that call, and the forward movement
    //    across recursion backtracking won’t work.
    // Making 'temp' a class-level (global) variable allows all recursion calls to share the same pointer
    // and move it forward correctly while comparing with nodes from the back.

    public boolean isPalindrome(Node head){     // the main function to solve the problem
        temp = head;
        return isPalindromeHelper(head);
    }

    public boolean isPalindromeHelper(Node node){

        if(node == null) return true;

        boolean ans = isPalindromeHelper(node.next);


        if(!ans) return false;
        if(temp.value != node.value) return false;
        temp = temp.next;

        return ans;
    }
    // another approach for this question can be :
    // you first find mid, now fast pointer points to the tail and slow points to the mid,
    // move slow back to head and create another function to reverse the linked list and reverse the linked list,
    // from mid to fast, now you can iterate and check,
    // que list 1,2,3,3,2,1
    // after reversing the forward half from mid to fast, the list becomes 1,2,3,1,2,3
    // thus you can now just iterate over it, and you will find the ans

    public static void main(String[] args) {
        PalindromeLL pal = new PalindromeLL();

        pal.insertFirst(1);
        pal.insertFirst(2);
        pal.insertFirst(2);
        pal.insertFirst(1);

        boolean sol = pal.isPalindrome(pal.head);
        System.out.println(sol);
    }
}
