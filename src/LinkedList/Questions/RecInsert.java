package LinkedList.Questions;

import LinkedList.LLquestions;

public class RecInsert extends LLquestions {

    // how to insert a new node at a particular position of the linked list using recursion:

    public Node insertRec(int index, int value){

        return insertRecHelper(index,value, head);

    }

    public Node insertRecHelper(int index, int value, Node temp){
        if(index == 0){
            Node node = new Node(value,temp);
            size++;
            return node;
        }

        temp.next = insertRecHelper(index - 1, value, temp.next);
        return temp;

        // why doesn't it require node = temp.next;
        // why doesn't it require temp.next = node;
        // because the recursion flow will break

    }

    public static void main(String[] args) {
        RecInsert questions = new RecInsert();
        questions.insertFirst(1);
        questions.insertFirst(1);
        questions.insertFirst(4 );
        questions.insertFirst(4);
        questions.insertFirst(4);
        questions.insertFirst(4);


        questions.insertRec(3,88);
        questions.display();
    }
}
