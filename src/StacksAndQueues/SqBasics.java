package StacksAndQueues;

import java.util.*;

public class SqBasics {
    public static void main(String[] args) {
        // creating a stack (LIFO):

        Stack<Integer> stack = new Stack<>();

        stack.push(8);
        stack.push(92);
        stack.push(2);
        stack.push(89);
        stack.push(3);
        stack.push(4);
        stack.push(1);      // last inserted element, element at the top

        System.out.println(stack.pop());        // this will pop the element at the top


        // QUEUES:
        System.out.println("queues:");
        // queue is an interface whereas stack is a class,
        // thus queue only contains some abstract methods declaration only without including there implementation
        // imagine queue implementation like linked lists,
        // imagine a line where the first person in the line the person in the front will be the head and we can take other people as nodes

        // so we can not just create an instance of queue by new queue as it can only be done for classes

        Queue<Integer> q = new LinkedList<>();
        q.add(8);
        q.add(3);
        q.add(32);
        q.add(438);
        q.add(12);

        // peek just gives the number in the front instead of removing it

        System.out.println(q.peek());   //only return the front node
        System.out.println(q.remove()); //removes 8
        System.out.println(q.peek());



        // DEQUE :
        // counter available at both the ends, we can remove from first or last and we can start from anywhere,
        // customer can take things from the start or the end its upto the customer
        System.out.println("deque");
        Deque<Integer> dq = new ArrayDeque<>();

        dq.add(88);
        dq.add(8);
        dq.add(4);
        dq.addLast(10);
        dq.addFirst(7);
        System.out.println(dq.removeFirst());
        System.out.println(dq.removeLast());
    }
}
