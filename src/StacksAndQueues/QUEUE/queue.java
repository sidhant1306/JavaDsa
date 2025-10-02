package StacksAndQueues.QUEUE;

public class queue extends customQueue {
    public static void main(String[] args) throws Exception {
        customQueue q = new customQueue();

        q.insert(7);
        q.insert(5);
        q.insert(234);
        q.insert(4);
        q.insert(34);
        System.out.println("removed element: ");
        System.out.println(q.remove());
        System.out.println("queue");
        q.display();

        System.out.println("Circular queue: ");
        circularQueue que = new circularQueue();

        que.insert(43);
        que.insert(2);
        que.insert(55);
        que.insert(65);
        que.insert(12);

        que.display();

        System.out.println("removing the element from the queue");
        System.out.println("removed element: ");
        System.out.println(que.remove());
        que.display();

        System.out.println("dynamic queue : ");
        dynamicQueue dq = new dynamicQueue(3);

        dq.insert(3);
        dq.insert(88);
        dq.insert(88);
        dq.insert(67);
        dq.insert(34);
        dq.display();
    }
}
