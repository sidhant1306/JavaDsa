package LinkedList.Questions;

import LinkedList.LLquestions;

public class ReorderList extends LLquestions {
    public void reOrder(Node head){
        if(head == null || head.next == null) return;

        // find the middle of the linked list using slow and fast pointers:

        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }


        // reverse the second half:

        Node second = reverseHalf(slow.next);
        // slow points to the middle element in this case thus to modify linked list after the first half we need to create a "second" node to store the value that we get from the recursion call
        slow.next = null;       // make it the tail
        // Merge the elements alternatively:

        Node first = head;      // to merge the left elements

        while(second != null){
            Node temp1 = first.next;
            Node temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }

    public Node reverseHalf(Node head){
        Node prev = null;
        Node curr = head;
        // 1 -> 2 -> 3 -> null
                // TO
        // null <- 1 <- 2 <- 3
        while(curr != null){
            Node next = curr.next;      // We must store the original next node first.
                                        // Because once we do curr.next = prev, the original link is lost.
            curr.next = prev;
            prev = curr;
            curr = next;                 // Use the stored next, not curr.next (curr.next is now changed!)
        }
        return prev;
    }

    public static void main(String[] args) {
        System.out.println("--- Testing Even Length List ---");
        ReorderList evenList = new ReorderList();
        evenList.insertFirst(4);
        evenList.insertFirst(3);
        evenList.insertFirst(2);
        evenList.insertFirst(1);
        System.out.print("Original: ");
        evenList.display(); // Expected: 1 -> 2 -> 3 -> 4 -> END
        evenList.reOrder(evenList.head);
        System.out.print("Reordered: ");
        evenList.display(); // Expected: 1 -> 4 -> 2 -> 3 -> END

        System.out.println("\n--- Testing Odd Length List ---");
        ReorderList oddList = new ReorderList();
        oddList.insertFirst(5);
        oddList.insertFirst(4);
        oddList.insertFirst(3);
        oddList.insertFirst(2);
        oddList.insertFirst(1);
        System.out.print("Original: ");
        oddList.display(); // Expected: 1 -> 2 -> 3 -> 4 -> 5 -> END
        oddList.reOrder(oddList.head);
        System.out.print("Reordered: ");
        oddList.display(); // Expected: 1 -> 5 -> 2 -> 4 -> 3 -> END
    }


    //    public void reOrderExample(Node head) {
//        if (head == null || head.next == null) {
//            return;
//        }
//        // Initialize our "left" pointer to the start of the list.
//        curr = head;
//        reOrderExampleHelper(head);
//    }
//
//    /**
//     * This helper function uses recursion to go to the end of the list.
//     * The `node` parameter is the node from the end on the way back.
//     * The shared `left` pointer is the node from the beginning.
//     */
//    public void reOrderExampleHelper(Node node) {
//        // 1. Recurse to the end of the list.
//        // The base case: when we're at the last node, the next call will be with `node.next` (null).
//        if (node == null) {
//            return;
//        }
//        reOrderExampleHelper(node.next);
//
//        // --- The Unwinding Phase ---
//        // The code below runs from the end of the list backwards.
//        // 'node' is the pointer from the end. 'left' is the pointer from the start.
//
//        // 2. The Stop Condition: This is the most important part.
//        // We stop re-wiring once the `left` pointer has met or passed the `node` pointer.
//        // We use `left == null` as a flag to mean "we have already stopped".
//        if (curr == null) {
//            return;
//        }
//
//        // For an ODD list (e.g., 1-2-3-4-5), left and node will meet at the middle node (3).
//        // For an EVEN list (e.g., 1-2-3-4), left will be at 2 and node at 3.
//        // In the next step, left would move to 3 and node would be 2. They have "crossed".
//        // The condition `left == node || left.next == node` detects the middle for both cases.
//        if (curr == node || curr.next == node) {
//            // We've found the middle. The 'node' should be the new tail.
//            node.next = null;
//            // Set our flag to stop any further re-wiring in shallower recursive calls.
//            curr = null;
//            return;
//        }
//
//
//        // 3. The Re-wiring Logic (if we haven't stopped yet)
//        Node temp = curr.next; // Save the next node from the front (e.g., save 2)
//        curr.next = node;     // Link front node to end node (1 -> 5)
//        node.next = temp;     // Link end node to the rest of the front (5 -> 2)
//
//        // 4. Move the `left` pointer forward for the next iteration.
//        curr = temp;
//    }

}
