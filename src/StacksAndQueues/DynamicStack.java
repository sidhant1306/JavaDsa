package StacksAndQueues;

public class DynamicStack extends customStack{

    // now as we know when we insert something in a stack the stack never gets full,
    // the in-built java stack uses a way to avoid getting full which is,
    // whenever the array gets full, it creates a new array of twice the size of the current array,
    // and it copies all the elements of the previous array and add them to the new array of twice the size.

    // Now in this all the things will be the same as the customStack like pop peek etc except the push method
    // We need to do something to be able to increase the size of the stack to push more elements in the stack when the stack gets full,


    // so we can directly call all the methods of the customStack class whenever this dynamicStack is called(using super):

    // creating a constructor for this:

    public DynamicStack(){
        super();        // it will call customStack whenever the dynamicStack class is called
    }

    public DynamicStack(int size){
        super(size);        // it will call customStack too but when dynamicStack is called with some size
    }


    // now the main thing is to do something that whenever the push method is called we create and call a new push method in the dynamicStack itself:

    @Override
    public boolean push(int item){
        // now we need to implement this method so that whenever the dynamicStack is called, this method will be called because it overrides the super class method:

        if(this.isFull()){
            // at this point the array is full
            int[] arr = new int[data.length * 2];   // new array of double the length created whenever the stack is full

            for (int i = 0; i < data.length; i++) {
                arr[i] = data[i];
            }
            data = arr;
        }
        // at this point the array size is doubled:

        return super.push(item);
    }


}
