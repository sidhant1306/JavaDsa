package StacksAndQueues.Questions.medium;

import static sun.util.locale.LocaleUtils.isEmpty;

public class Min_stack155 {
    public static int ptr = -1;
    public static int[] data;
    int default_size = 800;

    public Min_stack155(int size) {
        data = new int[size];
    }
    public Min_stack155() {
        this.data = new int[default_size];
    }

    public static void push(int val) {
        if(isFull()) {
            System.out.println("Stack is full.Data could not be inserted");
            return;
        }
        data[++ptr] = val;
    }
    public static boolean isFull() {
        return ptr == data.length - 1;
    }

    public static void pop() throws Exception{
        if(isEmpty()) throw new Exception("cannot pop, not element in the stack");
        int removed = data[ptr];
        ptr--;
        System.out.println("Element : "+removed + " is removed from the stack");
    }

    private static boolean isEmpty() {
        return ptr == -1;
    }

    public static int top() {
        return data[ptr];
    }

    public static int getMin() {
        return data[ptr];
    }
}
