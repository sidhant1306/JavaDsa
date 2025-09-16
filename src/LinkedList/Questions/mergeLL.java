package LinkedList.Questions;

import LinkedList.LLquestions;

public class mergeLL extends LLquestions {

    public static LLquestions LLmerge(LLquestions first, LLquestions second){
        Node head1 = first.head;    // the first list
        Node head2 = second.head;   // the second list

        // creating a new linked list which will store nodes of both the linkedLists

        LLquestions ans = new LLquestions();

        // now while both the lists have some elements in them:

        while(head1 != null && head2 != null){
            if(head1.value > head2.value){
                ans.insertLast(head1.value);
                head1 = head1.next;
            }
            else{
                ans.insertLast(head2.value);
                head2 = head2.next;
            }

            //if the first list has nodes remaining, and the other one is finished:
            while(head1 != null){
                ans.insertLast(head1.value);
                head1 = head1.next;
            }

            while(head2 != null){
                ans.insertLast(head2.value);
                head2 = head2.next;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // Merging two LinkedLists:
        LLquestions list1 = new LLquestions();
        LLquestions list2 = new LLquestions();
        list1.insertFirst(10);
        list1.insertFirst(20);
        list1.insertFirst(50);
        list1.insertFirst(88);

        list2.insertFirst(44);
        list2.insertFirst(55);
        list2.insertFirst(66);
        list2.insertFirst(99);

        LLquestions sol = LLmerge(list1,list2);
       sol.display();
    }
}
