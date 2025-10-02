package StacksAndQueues.QUEUE;

public class dynamicQueue extends circularQueue{
    public dynamicQueue(){
        super();
    }
    public dynamicQueue(int size){
        super(size);
    }

    // we just need to make one change, we need to do something whenever we insert any element


    @Override
    public boolean insert(int item) {

        // do something when the queue is full:
        if(isFull()){
            // when you double the array size while copying the array, we need to make sure we start inserting(copying) elements from front to end
            // at this point, the array is full
            int[] arr = new int[data.length * 2];   // new array of double the length created whenever the queue is full

            for(int i = 0; i < size; i++) {
                arr[i] = data[(front + i) % data.length];       // we do this because when we add the elements to the queue we do not do i because the front may not be at the 0th index
                // so we do this because, think about it if the front is at 2nd index so, (2 + 0) % 5 = 2, so whatever is at the 2nd position we insert it at the 0th index of the new queue
                // front is at the 2 position
            }
            front = 0;      // now the new queue is formed with the copy of the previous elements from front till end so make front = 0
            end = size;   // make the end = arr.length not arr.length - 1 because we want the end to be present an index after the ending index
            data = arr;     // now make the data which is our main queue = the newly formed bigger queue
        }
        // at this point, the array size is doubled:

        return super.insert(item);
    }
}
