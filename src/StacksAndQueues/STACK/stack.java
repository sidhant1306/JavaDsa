package StacksAndQueues.STACK;

public class stack {
    public static void main(String[] args) throws Exception {
        customStack stk = new customStack(2);

        stk.push(8);
        stk.push(48);
        System.out.println(stk.pop());;
        stk.push(823);
        stk.push(99);       // this will give error because we have initialized the size of the stack with 2 so we can only store 2 elements
    }
}
