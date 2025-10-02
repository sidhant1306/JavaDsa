package StacksAndQueues;

public class customQueue {

    protected int[] data;       // first we have a heap then we have a stack in which we have an array, so stack is a type of array that is why we have created an array which will work as a stack
    private static final int default_size = 10;


    public customQueue(int size){
        this.data = new int[size];
    }



    public customQueue(){
        this(default_size);
    }

    int ptr = -1;

    public boolean isFull() {
        return ptr == data.length - 1;      // if the pointer is at the last index, we cannot insert any more element
    }

    private boolean isEmpty(){
        return ptr == -1;
    }

    public boolean insert(int item){
        if(isFull()){
            return false;
        }
        ptr++;
        data[ptr] = item;

        return true;
    }

    public int remove() throws Exception {
        if(isEmpty()) throw new Exception("cannot remove element from an empty queue");

        // shift the elements to the left,
        // queue(arr) = 2,3,47,88  ->  left shift 3,47,88,0
        // as 2 is shifted to the left it goes to -1 index which is not present in the queue;

        // shifting of elements :
        int removed = data[0];
        for (int i = 1; i <= ptr; i++) {
            data[i - 1] = data[i];    // here we assign the data at the previous index with the current data
        }
        ptr--;
        return removed;
    }

    // method to return the value that is in the front of the queue :

    public int front() throws Exception {
        if(isEmpty()) throw new Exception("queue is empty");

        return data[0];
    }

    // method to display the entire queue:

    public void display(){
        for (int i = 0; i <= ptr; i++) {
            System.out.println(data[i] + " ");
        }
        System.out.println("End");
    }

}
