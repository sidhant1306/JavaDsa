package StacksAndQueues.Questions.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
// 100%
public class Histogram84 {
    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> areas = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
                int idx = stack.pop();
                int prevSmaller = 0;
                if (stack.isEmpty()) prevSmaller = -1;
                else prevSmaller = stack.peek();
                areas.add(heights[idx] * (i - prevSmaller - 1));
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int index = stack.pop();
            int pSmaller = 0;
            if(stack.isEmpty()) pSmaller = -1;
            else pSmaller = stack.peek();

            int nSmaller = heights.length;

            areas.add(heights[index] * (nSmaller - pSmaller - 1));
        }
        return Collections.max(areas);
    }

}
