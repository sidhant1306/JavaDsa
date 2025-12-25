package StacksAndQueues.Questions.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
//100%
public class DailyTemperatures739 {
    public static int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> nxtGreater = new ArrayList<>();
        int[] ans = new int[temperatures.length];

        // we have to store indexes in the stack instead of the values
        // find the next greater(index values) :

        for (int i = temperatures.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) nxtGreater.add(0);
            else nxtGreater.add(stack.peek());
            stack.push((i));
        }

        Collections.reverse(nxtGreater);
        for (int i = 0; i < temperatures.length; i++) {
            if(nxtGreater.get(i) == 0) ans[i] = 0;
            else ans[i] = nxtGreater.get(i) - i;
        }

        return ans;

    }

    // optimal solution :

    public static int[] dailyTemp(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) ans[i] = 0;
            else ans[i] = (stack.peek() - i);
            stack.push((i));
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] temp = {73,74,75,71,69,72,76,73};

        int[] ans = dailyTemp(temp);
        System.out.println(Arrays.toString(ans));
    }
}
