package LinkedList.Questions;

import LinkedList.LLquestions;

public class SortLL extends LLquestions {

    public Node sortList(Node head){
        if(head == null || head.next == null) return head;

        // find the middle:
        Node mid = findMiddle(head);    // using the findMiddle function

        Node right = mid.next;          // create a variable to start from the second half of the list
        mid.next = null;                     // disconnect the mid from the second part using .next = null
        // sort the parts of the list:
        Node leftSorted = sortList(head);       // use recursion, start from the head of the list
        Node rightSorted = sortList(right);     // start from the second half of the list

        // now merge the two sorted parts:

        return merge(leftSorted, rightSorted);
    }
    public Node findMiddle(Node head){
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // merge the two sorted lists using this function:

    public Node merge(Node first, Node second){
        // create a dummy node which will stay at null
        Node dummy = new Node(0);

        // now create a tail node at dummy position after which we will add all the elements one by one with smaller value:

        Node tail = dummy;

        while(first != null && second != null){
            // both lists have some elements remaining:
            if(first.value <= second.value){
                // add this smaller element(first) after the tail:
                tail.next = first;
                first = first.next;
            }
            else{
                tail.next = second;
                second = second.next;
            }
            tail = tail.next;
        }

        if(first != null) tail.next = first;
        if(second != null) tail.next = second;

        return dummy.next;
    }

    public static void main(String[] args) {
        SortLL list = new SortLL();

        list.insertFirst(24);
        list.insertFirst(4);
        list.insertFirst(88);
        list.insertFirst(90);
        list.insertFirst(1);
        list.insertFirst(80);

        list.display();

        System.out.println("sorting");
        list.head = list.sortList(list.head);
        list.display();


    }
}
