package LinkedList.Questions;

import LinkedList.LLquestions;

public class deleteNode237 extends LLquestions {

    public void deleteNode(Node node){
        node.value = node.next.value;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        deleteNode237 dlt = new deleteNode237();

        dlt.insertFirst(832);
        dlt.insertFirst(38);
        dlt.insertFirst(829);
        dlt.insertFirst(77);

        dlt.deleteNode(dlt.head.next);
        dlt.display();
    }
}
