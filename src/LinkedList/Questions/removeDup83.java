package LinkedList.Questions;

import LinkedList.LLquestions;

public class removeDup83 extends LLquestions {

// remove nodes with duplicate values (leetcode 83):

    private Node removeDupHelper(Node temp, Node temp1){
        if(temp1 == null) return temp;      // base condition reached: temp1 (the node in the forward position has reached null);

        if(temp.value == temp1.value){
            temp.next = temp1.next;     // it is used for removing the duplicate element, whenever a duplicate element is found the .next of temp pointing to its next node points to the .next of temp1 because it was previously pointing to temp1, which is now a duplicate
            return removeDupHelper(temp, temp1.next);
        }
        removeDupHelper(temp1, temp1.next);
        return temp1;
    }

    public void removeDup(){
        if(head == null) return;
        removeDupHelper(head, head.next);
    }



    //  ****************** My approach **************
    // Another approach (iterative), (better)
    public static void remove(Node head){
        Node temp1 = head;
        Node temp2 = head.next;

        while(temp2 != null){
            if(temp1.value == temp2.value){
                temp2 = temp2.next;
            }
            else{
                temp1.next = temp2;
                temp1 = temp2;
                temp2 = temp2.next;
            }
        }
        temp1.next = null;
    }
    public static void main(String[] args) {
        removeDup83 questions = new removeDup83();
        questions.insertFirst(1);
        questions.insertFirst(1);
        questions.insertFirst(4 );
        questions.insertFirst(4);
        questions.insertFirst(4);
        questions.insertFirst(4);


        questions.removeDup();
        questions.display();
    }
}
