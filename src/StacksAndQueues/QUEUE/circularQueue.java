package StacksAndQueues.QUEUE;

public class circularQueue {

    protected int[] data;       // first we have a heap then we have a stack in which we have an array, so stack is a type of array that is why we have created an array which will work as a stack
    private static final int default_size = 10;

    protected int front = 0;
    protected int end = 0;
    protected int size = 0;

    public circularQueue(int size){
        this.data = new int[size];
    }

    public circularQueue(){
        this(default_size);
    }



    public boolean isFull() {
        return size == data.length;      // if the pointer is at the last index, we cannot insert any more element
    }

    private boolean isEmpty(){
        return size == 0;
    }


    public boolean insert(int item){
        if(isFull()){
            return false;
        }

        data[end] = item;
        end++;
        end = end % data.length;     // end % size of the array
        size++;
        return true;
    }


    public int remove() throws Exception {
        if(isEmpty()) throw new Exception("cannot remove element from an empty queue");
        int removed = data[front];
        front++;
        front = front % data.length;
        size--;

        return removed;
    }

    // method to return the value that is in the front of the queue :

    public int front() throws Exception {
        if(isEmpty()) throw new Exception("queue is empty");

        return data[front];
    }

    public void display() throws Exception {
        if(isEmpty()) throw new Exception("no element present");
        int i = front;
        do{
            System.out.print(data[i] + " -> ");
            i++;
            i %= data.length;
        }while(i != end);
        System.out.println("END");
    }

}
