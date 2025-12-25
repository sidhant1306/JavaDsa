package StacksAndQueues.Questions.hard;

import java.util.Stack;
// Not optimal, Histogram84 is optimal and done fully independently
public class LargestRectangleInHistogram84 {
    public int largestRectangleArea(int[] heights) {
        int[] nextSmaller = nextSmallerElement(heights);
        int[] prevSmaller = prevSmallerElement(heights);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            int width = nextSmaller[i] - prevSmaller[i] - 1;

            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }

    public int[] prevSmallerElement(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[heights.length];
        int prevSmallerIndex = 0;
        for (int i = 0; i <= heights.length - 1; i++) {
            while(!(stack.isEmpty()) && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) ans[i] = -1;
            else ans[i] = stack.peek();
            stack.push(i);
        }
       return ans;
    }

    public int[] nextSmallerElement(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[heights.length];

        for (int i = heights.length - 1; i >= 0 ; i--) {
            while(!(stack.isEmpty()) && heights[i] <= heights[stack.peek()]) {
                stack.pop();
            }

            if(stack.isEmpty()) ans[i] = heights.length;
            else ans[i] = stack.peek();

            stack.push(i);
        }
        return ans;
    }
}
