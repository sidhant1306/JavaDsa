package LinkedList.doublyLinkedList;

import org.w3c.dom.Node;

public class DLLStructure {
// the only difference in a singly linked list and double-linked list is that it has a node pointing to prev as well
   private class Node{
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }

        public  Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    Node head;
   Node tail;
   int size = 0;


    public void insertFirst(int val){       // explained in the notes
        Node node = new Node(val);
        node.next = head;
        node.prev = null;

        if(head != null){
            head.prev = node;
        }
        head = node;

        if(tail == null){
            tail = node;
        }
        size++;
    }

    public void dllDisplay(){
        Node temp = head;

        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
    public void dllDisplayReverse(){
        Node temp = tail;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.prev;
        }
        System.out.println("END");
    }
    // inserting a new node at the last of the double-linked list:
    public void dllInsertLast(int val){
        Node node = new Node(val);
        Node temp = head;
        if(head == null){
            tail = node;
            head = node;
            return;
        }
        while(temp.next != null){
            temp = temp.next;
        }

        node.next = null;
        temp.next = node;
        node.prev = temp;

        tail = node;

        size++;
    }

    // to insert at a specific index in a double-linked list:
    public void insertSpecific(int index, int val){
        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("wrong index");
        }
        Node node = new Node(val);
        Node temp = head;
        if(index == 0){
            insertFirst(val);
            return;
        }
        if(index == size){
            dllInsertLast(val);
            return;
        }

        int i = 1;
        while(i < index){
            temp = temp.next;
            i++;
        }

        node.next = temp.next;  // temp.next does not point to node yet
        temp.next = node;       // temp.next now points to the new node
        node.prev = temp;
        node.next.prev = node;

        size++;

    }
}
