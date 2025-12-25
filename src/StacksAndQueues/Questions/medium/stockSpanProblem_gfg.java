package StacksAndQueues.Questions.medium;

import java.util.ArrayList;
import java.util.Stack;
//100%
public class stockSpanProblem_gfg {
    public static ArrayList<Integer> calculateSpan(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[i] >= arr[stack.peek()]) stack.pop();

            if(stack.isEmpty()) ans.add(i + 1);
            else ans.add(i - stack.peek());

            stack.push(i);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {10, 4, 5, 90, 120, 80};
        ArrayList<Integer> ans = calculateSpan(arr);
        System.out.println(ans);
    }
}
