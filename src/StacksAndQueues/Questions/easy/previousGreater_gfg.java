package StacksAndQueues.Questions.easy;

import java.util.ArrayList;
import java.util.Stack;

public class previousGreater_gfg {
    static ArrayList<Integer> preGreaterEle(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            while(!(stack.isEmpty()) && stack.peek() <= arr[i]) stack.pop();

            if(stack.isEmpty()) ans.add(-1);
            else ans.add(stack.peek());

            stack.push(arr[i]);
        }
        return ans;
    }
}
