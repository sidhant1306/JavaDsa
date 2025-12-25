package StacksAndQueues.Questions.easy;

import java.util.ArrayList;
import java.util.Stack;

public class prevSmaller_gfg {
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            while(!(stack.isEmpty()) && stack.peek() >= arr[i]) stack.pop();
            if(stack.isEmpty()) ans.add(-1);
            else ans.add(stack.peek());
            stack.push(arr[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1,6,2};
        ArrayList<Integer> sol = prevSmaller(arr);
        System.out.println(sol);
    }
}
