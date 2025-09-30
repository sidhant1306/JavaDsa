package LinkedList.SinglyLinkedList;
// THIS FILE WILL CONTAIN THE STRUCTURE CODE OF A LINKED LIST,
// LIKE WE WRITE LinkedList<Integer> = new LinkedList, and we add elements in it, but how does it work,
// we are going to create the linked list from the beginning via this file, we are going to build the linked list on our own

import org.w3c.dom.Node;

public class customLinkedList {


    // a linked list has node:

    public class Node {
        // a linked list node has two things val and the next pointer:
        public int value;
        public Node next;

        // now it will need a function to get the value of the node which will have two cases

        // case1: when we only have the value (only one node is present, and by default the value of next variable will be null if we have only one node):
        public Node(int value) {
            this.value = value;
        }

        // case 2: when we will have both the things the value and the next node pointer pointing to something :

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }


    }   // the structure of the node ends here(the node class ends here)

    // now apart from the node structure, a linked list has a head a tail and its size

    public Node head;
    public Node tail;
    public int size;



    // constructor for the current class:
    // it is for assigning it with a size like assigning a size to the current linked List file
    public customLinkedList(){
        this.size = 0;
    }



    // function to insert a new node at the first position:
    public void insertFirst(int val){   // val = value that we want to store at that position
        Node node = new Node(val);
        node.next = head;   // now the next node will be to the previous head because the head moved to the next position
        head = node;    // now the head will be the current node

        if(tail == null){       // if the tail is equal to null, it means that the linked list has only one element so the head and tail will be pointing to the same position
            tail = head;
        }

        size += 1;  // as we have added a new node, we have to increase the size of the linked list by 1
    }

    // Now to display the linked List:
    // we can't use while loop because in that case we will be moving the head to the next node till we reach null which will change the str of the linked list
    // and if we move the head pointer to the end of the linked list the next time we will not be able to print the linked list again because the head will already be at null
    // so we use a temporary variable which will move to the end of the list (to null)

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }


        // Method to insert node at the last position of the linked list:
     public void insertLast(int val){

         if(tail == null){
             insertFirst(val);      // the size will automatically increase by 1 bcz its mentioned in the insertFirst function
             return;
         }

        Node node = new Node(val);  // create the new node with some value
        tail.next = node;        // the node will be the next element to the current tail
        tail = node;            // the tail will be equal to the new node (last node)
        size++;             // the size will increase by 1


    }



    // insert at a particular position in the linked list:

    public void insertAt(int val, int pos){
        if(pos < 0 || pos > size){
            throw new IndexOutOfBoundsException("wrong index");
        }
        if(pos == 0){
            insertFirst(val);       // if we want to insert at the first position
            return;
        }
        else if(pos == size){
            insertLast(val);        // if we want to insert at the last position
            return;
        }
        Node temp = head;       // creating a temp variable which we will move to the position just before the pos
        int i = 1;
        while(i < pos - 1){     // pos - 1 because we need 1 to pos indexing, not 0 to pos indexing
            temp = temp.next;
            i++;
        }

        Node node = new Node(val);      // create the new node if we don't want to insert at head or tail

        node.next = temp.next;      // remember that temp.next still holds reference to the node.next when the new node is added
        temp.next = node;           // now the new node is created so temp.next points now to the new node

        size++;
    }

    // deleting the first node from the linked list:

    public void deleteFirst(){
        head = head.next;       // just move the head node to the next node, this way we won't be accessing the first node anyway
        size--;
    }
    // deleting the last node from the linked list (method 1):
    public void deleteLast(){
        Node temp = head;
        while(temp.next != tail){
            temp = temp.next;
        }
        tail = temp;
        tail.next = null;
        size--;
    }


    // removing a node from the last or from any other specific position from the linked list:

    // at first, we need a method which will take us to the previous element of the element what we want to remove,
    // for example, if we want to remove the last element we need to reach the element at size - 2
    // so we need a function which will take us to the element after knowing what is the position we need to remove

    public Node getReference(int index){
        // it is named getReference because we need to reach the position where we want to remove position.next
        Node temp = head;   // creating a temp node which will move to the next position
        for (int i = 0; i < index; i++) {
            temp = temp.next;   // moving the node to the next position
        }
        return temp;
    }

    // now the function to remove the last element:

    public void removeLastElement(){
        if(size <= 1){
            deleteFirst();
            return;
        }

        Node secondLast = getReference(size - 2);        // size - 2 because size - 1 gives us the last position so size - 2 will give us the element before the last position

        tail = secondLast;
        tail.next = null;
    }

    public void removeSpecific(int index){
        Node prev = getReference(index - 1);
        prev.next = prev.next.next;

    }

    // find a particular node with a value in a linked list:

    public boolean nodePresent(int value){
        Node temp = head;

        while(temp != null){
            if(temp.value == value){
                return true;
            }
             temp = temp.next;
        }return false;
    }

    public int posFinding(int val){
        Node temp = head;
        int i = 0;
        while(temp != null){
            if(temp.value == val){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return i;
    }


}



