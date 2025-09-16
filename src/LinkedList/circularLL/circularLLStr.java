package LinkedList.circularLL;

public class circularLLStr {
    Node head;
    Node tail;
    int size = 0;
    public circularLLStr(){
        this.head = null;
        this.tail = null;
    }

    private class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }


        // to insert a new node:
        public void insertFirst(int val){
            Node node = new Node(val);
            if(head == null){
                tail = node;
                head = node;
                tail.next = head;
                size++;
                return;
            }
            tail.next = node;
            node.next = head;
            tail = node;

            size++;
        }


        //This can work but notice that if we use this while loop, we have to explicitly print the value of tail at the last after the loop ends
        // this is because the loop runs until temp != tail, so when it becomes equal to tail it stops,
        // and we can't use while loop to run until it is equal to head because it is starting from head
        // so we need a do- while loop for this , as using that the loop will run at least once
//        public void displayCLL(){
//            Node temp = head;
//
//            while(temp != tail){
//                System.out.print(temp.value + " -> ");
//                temp = temp.next;
//            }
//            System.out.println(tail.value);
//
//        }

        // using do- while loop:

        public void displayCLL(){
            Node temp = head;
            if(head != null){
                do{
                    System.out.print(temp.value + " -> ");
                    temp = temp.next;
                }while(temp != head);
                System.out.println("HEAD");
            }
        }




        // if you want to delete the first node(head):

    public void deleteFirst(){
        if(head == null){
            return;
        }

        if(head == tail){
            head = null;
            tail = null;
        }
        else{
            head = head.next;
            tail.next = head;
        }
        size--;

    }




        // delete it from a particular position:

        public void deletePos(int pos){

            Node temp = head;
            if(pos <= 1){
                deleteFirst();
                return;
            }

            int i = 1;
            while(i < pos - 1){
                temp = temp.next;
                i++;
            }

            Node n = temp.next;
            if(n == tail){
               tail = temp;
               tail.next = head;
            }

            temp.next = n.next;
            size--;
        }

        // to delete a node by value
        public void deleteValue(int val){
            Node temp = head;

            // check for the first time if the value at head is equal to the value that you want to delete
            // it is a single check before starting the iteration
            // it is executed for a single time when the temp node is at the head position

            if(temp.value == val){
                head = head.next;   //it means you want to delete the head so you move to the next position(head.next)
                tail.next = head;
                return;
            }

            // now the loop:

            do{
                // otherwise, create a new node (n) which will move to the position next to the temp node (as done in the deletePos method):
                Node n = temp.next;
                if(n.value == val){
                    temp.next = n.next;
                    break;
                }
                temp = temp.next;
            }while(temp != head);
        }

    }

