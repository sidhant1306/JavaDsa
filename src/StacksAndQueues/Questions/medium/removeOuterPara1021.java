package StacksAndQueues.Questions.medium;

import java.util.*;

public class removeOuterPara1021 {

    public static String removeOuterParentheses(String s) {
        char[] que = s.toCharArray();
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (Character ch : que) {
            if(ch == '(') {
                if(!(stack.isEmpty())) ans.append(ch);      // if we have an opening bracket and the stack is not empty, there is something, it means we are in an inner parentheses so we need to add it to the ans
                stack.push(ch); // always push the stack for tracking
            }
            else{
                stack.pop();    // if we get a closing bracket then just remove it from the stack first, and then check,
                // After popping, check if the stack still has any '(' left
                // If it does, that means we are still inside another parenthesis group (not the outermost one)
                // So we add this ')' to the final answer
                // If the stack becomes empty, it means this ')' was the outermost closing bracket
                // So we skip adding it
                if(!(stack.isEmpty())) ans.append(ch);  // check if the stack still has a bracket left, if it does, add it to the ans

            }

        }
        return ans.toString();

    }

    public static void main(String[] args) {
        String s = "(()())(())(()(()))";
        String ans = removeOuterParentheses(s);
        System.out.println(ans);
    }
}