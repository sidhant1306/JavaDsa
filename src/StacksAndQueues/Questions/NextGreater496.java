package StacksAndQueues.Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NextGreater496 {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int[] ans1 = new int[nums1.length];
        List<Integer> ans2 = new ArrayList<>();
        for (int i = nums2.length - 1; i >= 0 ; i--) {

            while(!(stack.isEmpty()) && nums2[i] >= stack.peek()){       // until we find an element greater than the current element in the nums or stack becomes empty
                stack.pop();
            }

            if(stack.isEmpty()) ans2.add(-1);    // if no greater element was found and stack became empty
            else ans2.add(stack.peek());        // if a greater element was found, then it is the next greater
            stack.push(nums2[i]);        // always pushing the element of the array nums2, that we just checked.
        }
        // ans2 is ready, with all the next greater of elements of nums2.

        // now we need to somehow use these values for nums1.
        Collections.reverse(ans2);
        for (int i = 0; i < nums1.length; i++) {
            int idx = -1;
            for (int j = 0; j < nums2.length; j++) {
                if(nums1[i] == nums2[j]){
                    idx = j;
                    break;
                }
            }
            ans1[i] = ans2.get(idx);
        }
        return ans1;
    }

    public static void main(String[] args) {

    }
}
