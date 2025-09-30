package LinkedList.Questions;

import LinkedList.LLquestions;

public class SwapNodes extends LLquestions {

    // Function to swap every two adjacent nodes in the linked list
    public Node swapNode(Node head){
        // Base case: if a list is empty or has only one node, nothing to swap
        if(head == null || head.next == null) return head;

        // Initialize pointers for the first pair
        Node slow = head;       // slow points to the first node in the current pair
        Node fast = slow.next;  // fast points to the second node in the current pair

        // Update head to the new first node (after the first swap, the second node becomes head)
        head = fast;

        Node prev = null;       // prev will keep track of the end of the previous swapped pair

        // Iterate through the list swapping pairs
        while(fast != null) {
            Node Fnext = fast.next; // store the node after the current pair (needed for next iteration)

            // Swap the current pair
            fast.next = slow;   // the second node points back to the first node
            slow.next = Fnext;  // the first node points to the next node/pair

            // Connect a previous pair to the current swapped pair
            if(prev != null) prev.next = fast;

            // Update prev to the end of the current swapped pair
            prev = slow;

            // Move slow and fast pointers to the next pair
            slow = Fnext;
            if(Fnext != null) fast = Fnext.next; // fast points to second node of next pair
            else fast = null;                     // reached the end of the list
        }

        // Return the new head after all swaps
        return head;
    }

    public static void main(String[] args) {
        SwapNodes swap = new SwapNodes();

        // Insert nodes to create the linked list 1 -> 2 -> 3 -> 4
        swap.insertFirst(4);
        swap.insertFirst(3);
        swap.insertFirst(2);
        swap.insertFirst(1);

        // Display an original list
        swap.display();  // Output: 1 -> 2 -> 3 -> 4

        // Swap nodes in pairs and update head
        swap.head = swap.swapNode(swap.head);

        // Display a modified list
        swap.display();  // Output after swap: 2 -> 1 -> 4 -> 3
    }
}
