package LinkedList.SinglyLinkedList;

public class singlyLinkedListBasics {
    public static void main(String[] args) {
        // how to create a linked list by using pre-defined method:
//        LinkedList<Integer> list = new LinkedList<>();
//        list.add(304);
//        System.out.println(list);



        // referring to the other class(customLinkedList.java):

        customLinkedList LL = new customLinkedList();
        // when you want to insert a new element at the first position of the linked list:
        LL.insertFirst(8);
        LL.insertFirst(80);
        LL.insertFirst(890);
        LL.insertFirst(27);

        // to display the linkedList:
        LL.display();
        // another way (adding i to the start of the linked list):
        for (int i = 0; i < 10; i++) {
            LL.insertFirst(i);
        }
        LL.display();

        // to insert at the last position :
        LL.insertLast(90);
        LL.display();

        // to insert at any particular position:
        LL.insertAt(458,3);
        LL.display();

        // to delete the first node
        LL.deleteFirst();
        LL.display();

        // to delete the last node (method 1):
        LL.deleteLast();
        LL.display();

        // to delete the node from the last (method 2):
        LL.removeLastElement();
        LL.display();
        // to remove a specific node from the linked list:
        LL.removeSpecific(3);
        LL.display();

        // to check if a node is present inside the linked List:
        System.out.println(LL.nodePresent(89));
        System.out.println(LL.posFinding(2));
        }



}
