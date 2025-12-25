package StacksAndQueues.Questions.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class nextSmaller_gfg {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {

            while(!(stack.isEmpty()) && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                ans.add(-1);
            }
            else ans.add(stack.peek());

            stack.push(arr[i]);

        }
        Collections.reverse(ans);
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {4,8,5,2,25};
        ArrayList<Integer> ans = nextSmallerEle(arr);
        System.out.println(ans);
    }
}
