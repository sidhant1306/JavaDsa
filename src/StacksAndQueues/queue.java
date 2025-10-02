package StacksAndQueues;

public class queue extends customQueue{
    public static void main(String[] args) {
        customQueue q = new customQueue();

        q.insert(7);
        q.insert(5);
        q.insert(234);
        q.insert(4);
        q.insert(34);

        q.display();
    }
}
