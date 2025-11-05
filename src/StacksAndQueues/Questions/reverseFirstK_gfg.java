package StacksAndQueues.Questions;

import java.util.*;

public class reverseFirstK_gfg {

    public Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        int size = q.size();
        if(k > size) return q;
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> ans = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            stack.push(q.remove());
        }
        while (!(stack.isEmpty())) ans.add(stack.pop());
        while(!q.isEmpty()) ans.add(q.remove());
        return ans;
    }
    public static void main(String[] args) {

    }
}