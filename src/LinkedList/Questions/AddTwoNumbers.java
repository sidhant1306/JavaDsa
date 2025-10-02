package LinkedList.Questions;

import LinkedList.LLquestions;

public class AddTwoNumbers extends LLquestions {

    public Node addTwoNumbers(Node temp1, Node temp2){
        // as we need to add these two numbers in a new LL we need a dummy node pointing at the prev position from the head of the new node

        Node dummy = new Node(0);
        Node curr = dummy;              // the current node which we will move

        int carry = 0;  // to store carry

        while(temp1 != null || temp2 != null || carry != 0){
            // storing the value of the first node
            int val1 = temp1 != null ? temp1.value : 0;     // if we have some value at the temp1 node store its value at the current node to perform addition otherwise store 0 in cases when the nodes of the linked list has no more values(nodes finished)
            int val2 = temp2 != null ? temp2.value : 0;     // value if exists otherwise 0 because there might be a possibility of having no node in any one of the LL

            int currSum = val1 + val2 + carry;      // adding the values with carry
            carry = currSum / 10;                   // extracting the last digit
            int ans = currSum % 10;                 // the main digit we need to store on the new node

            curr.next = new Node(ans);
            curr = curr.next;

            if(temp1 != null) temp1 = temp1.next;
            if(temp2 != null) temp2 = temp2.next;
        }
        return dummy.next;
    }

}
