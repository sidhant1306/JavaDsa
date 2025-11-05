package StacksAndQueues.Questions;

import java.util.Stack;

public class isValid20 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) return false;
                char br = s.charAt(i);
                if (br == ')' && stack.peek() == '(' ||
                        br == ']' && stack.peek() == '[' ||
                        br == '}' && stack.peek() == '{') {
                    stack.pop();
                } else return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String test = "([)]{}";
        boolean ans = isValid(test);
        System.out.println(ans);
    }
}
