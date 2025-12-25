package StacksAndQueues.Questions.easy;

import java.util.*;

public class RemoveDuplicateAdjacents1047 {
    public static String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for(Character ch : s.toCharArray()) {
            if(stack.isEmpty()) {
                stack.push(ch);
            }
            else {
                if(ch == stack.peek()) stack.pop();
                else stack.push(ch);
            }

        }
        StringBuilder ans = new StringBuilder();
        while(!(stack.isEmpty())) ans.append(stack.pop());
        ans.reverse();
        return ans.toString();
    }

    public static void main(String[] args) {
        String ans = removeDuplicates("abbaca");
        System.out.println(ans);
        System.out.println("jsfdo");
    }
}