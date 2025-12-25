package StacksAndQueues.Questions.medium;

import java.util.Stack;

public class DeleteMidOfStack {
    public void deleteMid(Stack<Integer> s) {
        int middleFromBottom = (s.size() + 1) / 2;
        int middleFromTop = s.size() - middleFromBottom + 1;

        deleteMidHelper(s, middleFromTop, 1);
    } public void deleteMidHelper(Stack<Integer> s, int mid, int index) {
        if(s.isEmpty()) return;
        int popped = s.pop();

        deleteMidHelper(s, mid, index + 1);

        if(mid == index) return;

        s.push(popped);

    }
}
