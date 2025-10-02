package StacksAndQueues;


public class customStack {

    protected int[] data;       // first we have a heap then we have a stack in which we have an array, so stack is a type of array that is why we have created an array which will work as a stack
    private static final int default_size = 10;     // we are setting the default size to 10 when the user does not mention the size of the stack

    // we used static because we want all the objects of this class to have the same default size
    // we used private because we don't want anyone to change the value of the default_size
    // we used final because we do not want to change its value again either

    // now we are creating a constructor for the user to give size as an input when he creates the object of this stack:

    public customStack(int size){
        this.data = new int[size];
    }

    // what if the user does not provide the size:

    public customStack(){
        this(default_size);
    }
    int ptr = -1;       // this works as an index to move through the stack in order to insert and delete element
    // creating methods to insert and delete data:

    public boolean push(int item){
        // check if the stack is full, (you cannot insert a new element):
        if(isFull()){
            System.out.println("Stack is full cannot insert an element");
            return false;
        }
        ptr++;  // move to a pointer to the first element
        data[ptr] = item;
        return true;

    }
    // method to pop an element:
    public int pop() throws Exception {
        if(isEmpty()) throw new Exception("cannot pop from an empty stack");

        int removed = data[ptr];
        ptr--;
        return removed;
    }

    private int peek() throws Exception {
        if(isEmpty()) throw new Exception("cannot peek from an empty stack");
        return data[ptr];
    }
    public boolean isFull() {
        return ptr == data.length - 1;      // if the pointer is at the last index, we cannot insert any more element
    }

    private boolean isEmpty(){
        return ptr == -1;
    }

}
