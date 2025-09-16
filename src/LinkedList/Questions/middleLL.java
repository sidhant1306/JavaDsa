package LinkedList.Questions;

import LinkedList.LLquestions;

public class middleLL extends LLquestions {

    // my approach
    public  Node middle(Node temp, Node temp1){
        int i = 0;
        int count = 1;
        if(temp == null){
            return null;
        }
        while(temp.next != null){
            temp = temp.next;
            count++;

        }

        while(i < (count) / 2){
            temp1 = temp1.next;
            i++;
        }

        return temp1;

    }

    // better approach:

    public Node middleOfLL(Node head){
        Node temp = head;
        int count = 0;

        while(temp != null){
            count++;
            temp = temp.next;
        }

        Node mid =  head;
        for (int i = 0; i < count / 2; i++) {
            mid = mid.next;     // move the node present below the temp node
        }
        return mid;
    }

    public static void main(String[] args) {
        middleLL mLL = new middleLL();

        mLL.insertFirst(88);
        mLL.insertFirst(77);
        mLL.insertFirst(900);
        mLL.insertFirst(90);
        mLL.insertFirst(3);
        mLL.insertFirst(5);

        mLL.display();

   Node ans =  mLL.middle(mLL.head, mLL.head);
        System.out.println(ans.value);

    }
}
